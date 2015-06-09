/**
 * Created by lte on 2015/5/26.
 */
import java.util.*;
public class PermutationSequence3 {
    public String getPermutation(int n, int k) {
        StringBuilder totalSet = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        k--;//Ԫ�ش�0��ʼ��
        int sum = 1;//��׳ˣ�Ҳ���������еĸ���
        for(int i = 1; i <= n; i++){
            sum *= i;
            totalSet.append(i);
        }

        for(int i = n; i >= 1; i--){
            sum /= i;//n��Ԫ��ʱ��ÿ����ͬ��ͷ�����Ԫ�ظ�����
            int index = k / sum; //��k��Ԫ���ڵڼ��飬Ҳ�����ҵ��˵�һ�������λ��
            k = k % sum;//���������Ǹ����ڣ�k�����������
            ans.append(totalSet.charAt(index));
            totalSet.deleteCharAt(index);
        }

        return ans.toString();

    }
    public static void main(String[] args){
        //long t0 = System.currentTimeMillis();
        System.out.println(new PermutationSequence3().getPermutation(9, 24));//24,9 error???�׳˻�Խ�磻
        //long t1 = System.currentTimeMillis();
        //System.out.println(t1 + " " + t0 + " " + (t1-t0));
    }
}
