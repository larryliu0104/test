package Coursera;

/**
 * Created by lte on 2015/5/26.
 */
/**
 * Created by zbb on 2015/5/4.
 */
public class PrimeTest {
    public static void main(String[] args){
        //���з���1���1-100�����������
        getPrime1();
        //���з���2���1-100�����������
        getPrime2();
    }

    //����1���ȳ�ʼ��һ��0-100������λ��Ȼ���ų����Ա������Ķ�Ӧλ����ʣ��λ�ô�������־������������ġ�
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

    //����2���ж�һ�������Ƿ�������˱�1���Լ�����
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