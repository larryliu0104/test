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
            if(temp == mid){//ǡ����ƽ����
                return mid;
            }else if(temp < mid){//˵��mid̫�󣬽������ߣ�
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
