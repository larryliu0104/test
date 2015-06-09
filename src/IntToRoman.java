/**
 * Created by lte on 2015/6/5.
 */
public class IntToRoman {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};//�Ӵ�С�ı�ʾ
        String[] romans ={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};//�������Ӧ���������ֱ�ʾ��
        StringBuilder ans = new StringBuilder();
        //nums�ǴӴ�С�ı�ʾ����num�Ƿ������ʼ����ֵ��������㣬�����������Ӧ�������ַ�������numsǰ�������ж�
        for(int i = 0; i < nums.length; i++){
            while(num >= nums[i]){
                ans.append(romans[i]);
                num -= nums[i];
            }
        }
        return ans.toString();
    }
}
