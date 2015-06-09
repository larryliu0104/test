package Coursera;

/**
 * Created by lte on 2015/5/26.
 */
/**
 * Created by zbb on 2015/5/4.
 */
public class PrimeTest {
    public static void main(String[] args){
        //运行方法1获得1-100以内质数结果
        getPrime1();
        //运行方法2获得1-100以内质数结果
        getPrime2();
    }

    //方法1：先初始化一个0-100的数组位，然后排除可以被整除的对应位数，剩下位置代表的数字就是满足条件的。
    private static void getPrime1() {
        int N = 100;

        boolean[] a = new boolean[N+1];
        for(int i=0; i<=N; i++) a[i]=true;

        for(int i=2; i<=N; i++){
            for(int j=2*i; j<=N; j+=i){
                a[j] = false;
            }
        }

        for( int i=2; i<=N; i++ ){
            if(a[i]) System.out.println(i);
        }
        System.out.println("Total elements : " + a);
    }

    //方法2：判断一个数字是否满足除了被1和自己整除
    private static void getPrime2(){
        outset:
        for (int x=2;x<=100;x++){
            for(int i=2; i<x; i++) {
                if (x%i==0) continue outset;
            }
            System.out.println(x);
        }
    }
}