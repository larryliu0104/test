/**
 * Created by lte on 2015/6/7.
 */
public class Sqrt {
    public int mySqrt(int x) {
        if(x < 0) return -1;
        if(x == 0) return 0;
        int l = 1;
        int r = x;
        while(l < r - 1){
            int mid = l + (r - l) / 2;
            int temp = x / mid;
            if(temp == mid){//恰好是平方根
                return mid;
            }else if(temp < mid){//说明mid太大，结果在左边；
                r = mid;
            }else{
                l = mid;
            }
        }
        return l;
    }
    public static void main(String[] args){
        System.out.println(new Sqrt().mySqrt(2));
    }
}
