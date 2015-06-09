/**
 * Created by lte on 2015/6/7.
 */
public class DivideTwoIntegers3 {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        long ans = 0;
        long dividendTmp = Math.abs((long)dividend);
        long divisorTmp = Math.abs((long)divisor);
        while(dividendTmp >= divisorTmp){//计算绝对值除法,除数也可能是负的，所以这里要用divisorTmp，不能用divisor
            long divisorFactor = 1;//除数的膨胀系数
            long amplifiedDivisorTmp = divisorTmp;//这个别忘了，要重头再来
            while(dividendTmp >= amplifiedDivisorTmp){
                dividendTmp -= amplifiedDivisorTmp;
                ans += divisorFactor;
                divisorFactor = (divisorFactor << 1);//相当于乘以2；
                amplifiedDivisorTmp = (amplifiedDivisorTmp << 1);
            }
        }
        //确定符号
        ans = ((((dividend^divisor) >> 31) & 1) == 1)? -ans : ans;
        return (int)ans;
    }
    public static void main(String[] args){
        System.out.println(new DivideTwoIntegers3().divide(-1010369383, -2147483648));
    }
}
