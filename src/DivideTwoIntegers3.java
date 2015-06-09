/**
 * Created by lte on 2015/6/7.
 */
public class DivideTwoIntegers3 {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        long ans = 0;
        long dividendTmp = Math.abs((long)dividend);
        long divisorTmp = Math.abs((long)divisor);
        while(dividendTmp >= divisorTmp){//�������ֵ����,����Ҳ�����Ǹ��ģ���������Ҫ��divisorTmp��������divisor
            long divisorFactor = 1;//����������ϵ��
            long amplifiedDivisorTmp = divisorTmp;//��������ˣ�Ҫ��ͷ����
            while(dividendTmp >= amplifiedDivisorTmp){
                dividendTmp -= amplifiedDivisorTmp;
                ans += divisorFactor;
                divisorFactor = (divisorFactor << 1);//�൱�ڳ���2��
                amplifiedDivisorTmp = (amplifiedDivisorTmp << 1);
            }
        }
        //ȷ������
        ans = ((((dividend^divisor) >> 31) & 1) == 1)? -ans : ans;
        return (int)ans;
    }
    public static void main(String[] args){
        System.out.println(new DivideTwoIntegers3().divide(-1010369383, -2147483648));
    }
}
