import java.util.LinkedList;

/**
 * Created by lte on 2015/5/25.
 */
public class PermutationSequence2 {
    public String getPermutation(int n, int k) {
        // 1:17 -> 1:43
        LinkedList<Character> digits = new LinkedList<Character>();

        // bug 2: should only add n elements.
        for (char i = '1'; i <= '0' + n; i++) {
            digits.add(i);
        }

        // The index start from 0;
        k--;
        StringBuilder sb = new StringBuilder();

        int sum = 1;
        // n!
        for (int i = 1; i <= n; i++) {
            sum *= i;//����һ���ж���������
        }

        for (int i = n; i >= 1; i--) {
            sum /= i;//��ͷ���ֲ�ͬ�ķ�Ϊsum��
            int digitIndex = k / sum;//k���ڵڼ��飻
            k = k % sum;//�����ٷ�����k�Ĵ���

            //Line 25: error: cannot find symbol: method digits(int)
            sb.append(digits.get(digitIndex));

            // remove the used digit.
            digits.remove(digitIndex);//�ٷ�����ǰ���Ԫ�ؾͲ�Ҫ�����
        }

        return sb.toString();
    }
    public static void main(String[] args){
        long t0 = System.currentTimeMillis();
        System.out.println(new PermutationSequence2().getPermutation(9, 24));//24,9 error???
        long t1 = System.currentTimeMillis();
        System.out.println(t1 + " " + t0 + " " + (t1-t0));
    }
}
