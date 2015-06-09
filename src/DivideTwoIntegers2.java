/**
 * Created by lte on 2015/6/5.
 */
public class DivideTwoIntegers2 {
    public int divide(int dividend, int divisor) {
        //这里必须先long再abs？和最小值有关？
        long dividendtmp = Math.abs(dividend);
        long divisortmp = Math.abs(divisor);
        int ans = 0;
        while(dividendtmp >= divisortmp){//此时剩余被除数大于除数，进循环
            long amplifyDivisorTmp = divisortmp;
            long partialDivisor = 1;//阶段性成果,2倍增加，膨胀到减不动为止

            while(dividendtmp >= amplifyDivisorTmp){//剩余被除数大于膨胀除数，继续循环
                dividendtmp -= amplifyDivisorTmp;//被除数减少
                ans += partialDivisor;//结果相应增加

                amplifyDivisorTmp <<= 1;//除数膨胀
                partialDivisor <<= 1;//待增加结果膨胀
            }
            //按位亦或最高位是1说明符号不同，是0说明负号相同
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
