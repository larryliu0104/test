/**
 * Created by lte on 2015/6/6.
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int top = 0;
        int bottom = matrix.length - 1;
        //���еķ�Χ��С��1-2��
        while(bottom > top + 1){
            int index = (bottom + top)/2;
            int temp = matrix[index][0];
            if(temp == target){
                return true;
            }else if(temp > target){
                bottom = index - 1;
            }else if (temp < target){
                top = index;
            }
        }
        //��ʣ������
        if(bottom == top){//ʣһ��
            return judgeLine(matrix, target, top);
        }else{//ʣ����
            if(matrix[bottom][0] == target) {
                return true;
            }
            else if(matrix[bottom][0] > target){
                return judgeLine(matrix, target, top);
            }else{
                return judgeLine(matrix, target, bottom);
            }
        }
        //return false;//��䲻��Ҫ�ɣ���֪��ȥ���������ܸ�����
    }
    private boolean judgeLine(int[][] matrix, int target, int line){
        int left = 0;
        int right = matrix[0].length - 1;
        while(left <= right){
            int index = (left + right) / 2;
            if(matrix[line][index] == target) return true;
            else if(matrix[line][index] > target) right = index - 1;
            else left = index + 1;
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix = {{1}};
        int target = 1;
        System.out.println(new Search2DMatrix().searchMatrix(matrix, 1));
    }
}
