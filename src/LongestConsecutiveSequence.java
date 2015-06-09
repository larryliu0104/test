/**
 * Created by lte on 2015/6/8.
 */
import java.util.*;
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num){
        if (num == null){
            return -1;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : num){//��Ԫ�ض�װ��Hashset
            set.add(i);
        }
        int max = 0;
        for(int i : num){
            int count = 0;
            if(set.contains(i)){
                set.remove(i);
                count++;
                int plus = i + 1;
                while(set.contains(plus)){//��ǰ������
                    set.remove(plus);//�ҵ���ɾ����ֹ�����ظ��ң���ʡʱ�䣬�Ҿ��Ų�ɾҲ���ܹ�������ʱ�临�ӶȻᳬ��n
                    count++;
                    plus++;
                }
                int minus = i - 1;
                while (set.contains(minus)){//���������
                    set.remove(minus);
                    minus--;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;

    }
    public static void main(String[] args){
        int[] num = {5, 6, 100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(num));
    }
}
