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
        for(int i : num){//把元素都装进Hashset
            set.add(i);
        }
        int max = 0;
        for(int i : num){
            int count = 0;
            if(set.contains(i)){
                set.remove(i);
                count++;
                int plus = i + 1;
                while(set.contains(plus)){//向前找连续
                    set.remove(plus);//找到就删，防止后面重复找，节省时间，我觉着不删也能跑过，就是时间复杂度会超过n
                    count++;
                    plus++;
                }
                int minus = i - 1;
                while (set.contains(minus)){//向后找连续
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
