/**
 * Created by lte on 2015/5/17.
 */
import java.util.*;
public class AnagramsSelf {
    public List<String> anagrams(String[] strs) {
        List<String> ans = new ArrayList<String>();
        if(strs == null) return ans;
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String temp : strs){//coustruct a perfect datastructure to solve this problem
            char[] c = temp.toCharArray();//change to char arr to sort
            Arrays.sort(c);
            String sortedStr = String.valueOf(c);//返回 char 数组参数的字符串表示形式
            if(map.containsKey(sortedStr)){
                map.get(sortedStr).add(temp);
            }else{
                map.put(sortedStr, new ArrayList<String>());
                map.get(sortedStr).add(temp);
            }
        }
        for(String tempString : map.keySet()){
            List<String> tempList = map.get(tempString);
            if(tempList.size() > 1){//have brothers
                ans.addAll(tempList);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        String[] strs = {"abc", "bca", "bac", "bbb", "bbca", "abcb"};
        System.out.println(new AnagramsSelf().anagrams(strs));
    }
}
