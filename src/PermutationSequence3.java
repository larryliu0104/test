/**
 * Created by lte on 2015/5/26.
 */
import java.util.*;
public class PermutationSequence3 {
    public String getPermutation(int n, int k) {
        StringBuilder totalSet = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        k--;//元素从0开始；
        int sum = 1;//求阶乘，也就是总排列的个数
        for(int i = 1; i <= n; i++){
            sum *= i;
            totalSet.append(i);
        }

        for(int i = n; i >= 1; i--){
            sum /= i;//n个元素时，每个不同开头引领的元素个数；
            int index = k / sum; //第k个元素在第几组，也就是找到了第一个结果的位置
            k = k % sum;//进入上面那个组内，k的索引情况；
            ans.append(totalSet.charAt(index));
            totalSet.deleteCharAt(index);
        }

        return ans.toString();

    }
    public static void main(String[] args){
        //long t0 = System.currentTimeMillis();
        System.out.println(new PermutationSequence3().getPermutation(9, 24));//24,9 error???阶乘会越界；
        //long t1 = System.currentTimeMillis();
        //System.out.println(t1 + " " + t0 + " " + (t1-t0));
    }
}
