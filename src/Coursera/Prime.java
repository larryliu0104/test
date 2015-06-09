package Coursera;

/**
 * Created by lte on 2015/5/26.
 */
public class Prime {

    static int list[] = new int[99];


//��ʼ������

    public static void init(){

        for (int i=0;i<list.length;i++){

            list[i] = i+2;

        }

    }


//�ж��Ƿ�Ϊ����

    public static boolean isPrime(int num){

        if(num == 0 || num == 1){

            return false;

        }else if (num == 2){

            return true;

        }else if(num%2 == 0 || num <0){

            return false;

        }else{

            for(int i=3;i<Math.sqrt(num);i+=2){

                if(num%i==0){

                    return false;

                }

            }

        }

        return true;

    }


//��ӡ����

    public static  void printPrime(){


        System.out.println("100���ڵ�����");

        int count = 0;

        for(int num:list){

            if(num != -1){

                if(count % 5 == 0 && count != 0 ){

                    System.out.println(num);

                }else{

                    System.out.print(num+" ");

                }

                count++ ;

            }

        }

        System.out.println("\n�ܼƣ�"+count+"��");


    }


    public static void main(String[] args) {

        init();


//�ҳ��̣�100�������е���������2��100�����������ܱ�10����������������Ϊ��Ϊ��������ֵ��1

        for (int i=0; i < Math.sqrt(list.length); i++) {

            if(isPrime(list[i])==true){

                for(int j=0;j<list.length;j++){

                    if(list[j]%list[i] == 0 && list[j] != list[i]){

                        list[j] = -1;

                    }

                }

            }

        }


        printPrime();

    }


}