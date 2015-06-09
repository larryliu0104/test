/**
 * Created by lte on 2015/6/5.
 */
public class DivideTwoIntegers2 {
    public int divide(int dividend, int divisor) {
        //���������long��abs������Сֵ�йأ�
        long dividendtmp = Math.abs(dividend);
        long divisortmp = Math.abs(divisor);
        int ans = 0;
        while(dividendtmp >= divisortmp){//��ʱʣ�౻�������ڳ�������ѭ��
            long amplifyDivisorTmp = divisortmp;
            long partialDivisor = 1;//�׶��Գɹ�,2�����ӣ����͵�������Ϊֹ

            while(dividendtmp >= amplifyDivisorTmp){//ʣ�౻�����������ͳ���������ѭ��
                dividendtmp -= amplifyDivisorTmp;//����������
                ans += partialDivisor;//�����Ӧ����

                amplifyDivisorTmp <<= 1;//��������
                partialDivisor <<= 1;//�����ӽ������
            }
            //��λ������λ��1˵�����Ų�ͬ����0˵��������ͬ
            int i = (0xffffffff >> 31);
            int j = 0xffff >> 15;
            int k = (-1 >> 1);
            int l = -1;
            //ans = (((dividend^divisor) >> 31)==1)? -ans: ans;
            ans = ((((dividend ^ divisor) >> 31) & 1) == 1) ? -ans: ans;
        }
        return ans;
    }
    public static void main(String[] args){
        int i = (11 >> 1);
        System.out.println(new DivideTwoIntegers2().divide(-1, 1));
    }
}
