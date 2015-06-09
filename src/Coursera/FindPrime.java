package Coursera;

/**
 * Created by lte on 2015/5/26.
 */
import java.util.*;
class FindPrime{
    private ArrayList<Integer> findPrime(int limit){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(limit < 2) return ans;
        ans.add(2);
        for(int i = 3; i <= limit; i++){
            if(isPrime(i)){
                ans.add(i);
            }
        }
        return ans;

    }

    //codes below are used to judge whether the input value is a prime;
    private boolean isPrime(int value){
        for(int i = 2; i <= value/2; i++){
            if(value % i == 0) return false;
        }
        return true;
    }

    //main method is used to print out all prime numbers within 100
    public static void main(String[] args){
        System.out.println(new FindPrime().findPrime(100));
    }
}