/**
 * Created by lte on 2015/5/17.
 */
import java.util.*;
public class MimimumWindowSubstring {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> toBeFound = new HashMap<Character, Integer>();
        HashMap<Character, Integer> isFound = new HashMap<Character, Integer>();
        for (Character ch: T.toCharArray()) {//初始化待查找和已找到Hashmap
            if (toBeFound.containsKey(ch)) {//如果待查找字符串有重复，会进到这个if循环
                toBeFound.put(ch, toBeFound.get(ch) + 1);//有重复说明待查找已经有至少一个了，所以增加待查找计数；
            } else {//无重复进入这个
                toBeFound.put(ch, 1);//含义是待查找1个；
                isFound.put(ch, 0);//含义是已找到0个；
            }
        }
        int count = 0;//找到待查找字符的计数
        int currentMinWinStart = 0;
        int currentMinWinEnd = 0;
        String result = "";
        while (currentMinWinEnd < S.length()) {
            char cur = S.charAt(currentMinWinEnd);
            if (!toBeFound.containsKey(cur)) {//目前字符没有则前进继续前进查找
                currentMinWinEnd++;
                continue;
            }
            isFound.put(cur, isFound.get(cur) + 1);//找到了给isFound这位的index加1
            if (isFound.get(cur) <= toBeFound.get(cur)) {//不但找到，而且找到的是有用的，把找到计数加1；举例比如要在aaaaab里找ab，2-4的a就是暂时没用的
                count++;
            }

            if (count == T.length()) {
                // locate start point
                while(true) {
                    char tempStart = S.charAt(currentMinWinStart);
                    if (!toBeFound.containsKey(tempStart)) {//起点和待查找字符无关，起点放心前移好了
                        currentMinWinStart++;
                        continue;
                    }
                    if (isFound.get(tempStart) > toBeFound.get(tempStart)) {//找到的个数比待查找个数多，可以考虑移动窗口啦
                        isFound.put(tempStart, isFound.get(tempStart) - 1);//找到个数减1，窗口右移一位；
                        currentMinWinStart++;
                        continue;
                    } else {//如果起点字符经判断已经不比待查找多，窗口就不能在前移了，前移就缺元素啦
                        break;
                    }
                }
                if (result.equals("") || result.length() > currentMinWinEnd - currentMinWinStart + 1) {//结果为空大胆更新，结果比新计算的长，也要更新成更短的
                    result = S.substring(currentMinWinStart, currentMinWinEnd + 1);
                }
            }
            currentMinWinEnd++;
        }
        return result;
    }

    public static void main(String[] args){
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String S1 = "acbbaca";
        String T1 = "aba";
       // System.out.println(new MimimumWindowSubstring().minWindow(S, T));
        System.out.println(new MimimumWindowSubstring().minWindow(S1, T1));
    }
}
