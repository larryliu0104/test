/**
 * Created by lte on 2015/6/8.
 */
import java.util.*;
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        List<Integer> ans = new ArrayList<Integer>();

        if(s == null || words == null) return ans;

        for(String str : words){//把待查找数组words整合进hashmap
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);//get找不到返回null，而不是0，所以if和else不能合并
            }else{
                map.put(str, 1);
            }
        }

        int isFound = 0;
        int wordL = words[0].length();
        for(int i = 0; i < s.length() - wordL * words.length; i++){//注意边界条件
            found.clear();//清除重来
            isFound = 0;
            for(int j = i; j < s.length() - wordL; j += wordL){
                String temp = s.substring(j, j + wordL);
                if(map.containsKey(temp)){
                    if(found.containsKey(temp)){
                        if(found.get(temp) == map.get(temp)){//found已经加满了，这个冒了，跳出
                            break;
                        }else{//found没加满，加进来
                            found.put(temp, found.get(temp) + 1);
                        }
                    }else{//found里还没有，map有，加进来
                        found.put(temp, 1);
                    }
                }else{//map里没有
                    break;
                }

                if(found.get(temp) == map.get(temp)){//加了之后满了，找到单词加1
                    isFound++;
                }

                if(isFound == map.size()){
                    ans.add(i);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        String s = "a";
        String[] words = {"a"};
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s, words));
    }
}
