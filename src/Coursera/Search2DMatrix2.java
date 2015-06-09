package Coursera;

/**
 * Created by lte on 2015/6/6.
 */
public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int totalNum = row * col;
        int start = 0, end = totalNum - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;//这个和(start + end) / 2有啥不同？
            int currentRow = mid / row;
            int currentCol = mid % row;
            int currentVal = matrix[currentRow][currentCol];
            if(currentVal == target){
                return true;
            }else if(currentVal > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix = {{1, 1}};
        int target = 2;
        System.out.println(new Search2DMatrix2().searchMatrix(matrix, target));
    }
}
