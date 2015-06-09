/**
 * Created by lte on 2015/6/5.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        // Note: 在这里必须先取long再abs，否则int的最小值abs后也是原值
        long dividendTmp = Math.abs((long)dividend);
        long divisorTmp = Math.abs((long)divisor);

        // bug 3: ret should use Long to avoid overflow.
        long ret = 0;
        // bug 2: should use dividentTmp > divisor as the while judge.
        while (dividendTmp >= divisorTmp) {
            // bug 1: should use Long for tmp.
            long tmp = divisorTmp;
            int rst = 1;
            while(tmp <= dividendTmp) {
                // bug 3: the two statement should inside the while LOOP.
                ret += rst;
                dividendTmp -= tmp;

                tmp <<= 1;
                rst <<= 1;
            }
        }
        // bug 4: out of range:
        /*
        Input:    -2147483648, -1
        Output:    -2147483648
        Expected:    2147483647
        */
        //ret = ((dividend > 0) ^ (divisor > 0)) ? -ret: ret;
        ret = ((((dividend ^ divisor) >> 31) & 1) == 1) ? -ret: ret;

        if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int)ret;
        }
    }
    public static void main(String[] args){
        System.out.println(new DivideTwoIntegers().divide(1000, 3));
    }
}
