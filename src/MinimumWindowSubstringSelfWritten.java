/**
 * Created by lte on 2015/5/17.
 */
import java.util.*;
public class MinimumWindowSubstringSelfWritten {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> toBeFound = new HashMap<Character, Integer>();
        HashMap<Character, Integer> isFound = new HashMap<Character, Integer>();
        char[] tArr = t.toCharArray();
        for(char temp : tArr){//initialize toBeFound and isFound
            if(toBeFound.containsKey(temp)){
                toBeFound.put(temp, toBeFound.get(temp) + 1);
            }else{
                toBeFound.put(temp, 1);
                isFound.put(temp, 0);
            }
        }
        int count = 0;
        int start = 0, end = 0;
        String result = "";
        while(end < s.length()){
            char temp = s.charAt(end);
            if(!toBeFound.containsKey(temp)){//not char we are finding, continue
                end++;
                continue;
            }
            else{
                isFound.put(temp, isFound.get(temp) + 1);
                if(isFound.get(temp) <= toBeFound.get(temp)){
                    //not only the element we are finding but also the element we are lacking, increase count
                    count++;
                }
            }

            if(count == t.length()) {
                while (true) {
                    char tempStart = s.charAt(start);
                    if (!toBeFound.containsKey(tempStart)) {
                        start++;
                        continue;
                    } else {
                        if (toBeFound.get(tempStart) < isFound.get(tempStart)) {//has surplus
                            start++;
                            isFound.put(tempStart, isFound.get(tempStart) - 1);
                        } else {//no surplus, should break the loop
                            break;
                        }
                    }
                }


                if (result == "" || end - start + 1 < result.length()) {
                    result = s.substring(start, end + 1);
                }
            }


            end++;
        }
        return result;
    }
    public static void main(String[] args){
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String S1 = "acbbaca";
        String T1 = "aba";
        System.out.println(new MinimumWindowSubstringSelfWritten().minWindow(S, T));
        System.out.println(new MinimumWindowSubstringSelfWritten().minWindow(S1, T1));
    }
}
