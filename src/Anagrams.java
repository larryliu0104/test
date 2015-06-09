/**
 * Created by lte on 2015/5/17.
 */
import java.util.*;
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        List<String> ans = new ArrayList<String>();
        if (strs == null || strs.length == 0) {
            return ans;
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<String>());
            }
            map.get(sorted).add(str);
        }
        for (List<String> list: map.values()) {
            if (list.size() > 1) {
                ans.addAll(list);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        String[] strs = {"abc", "bca", "bac", "bbb", "bbca", "abcb"};
        System.out.println(new Anagrams().anagrams(strs));
    }
}
