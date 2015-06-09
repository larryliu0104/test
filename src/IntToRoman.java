/**
 * Created by lte on 2015/6/5.
 */
public class IntToRoman {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};//从大到小的表示
        String[] romans ={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};//与上面对应的罗马数字表示；
        StringBuilder ans = new StringBuilder();
        //nums是从大到小的表示，看num是否满足最开始的数值，如果满足，给结果加入相应的罗马字符，否则nums前进继续判断
        for(int i = 0; i < nums.length; i++){
            while(num >= nums[i]){
                ans.append(romans[i]);
                num -= nums[i];
            }
        }
        return ans.toString();
    }
}
