/**
 * Created by lte on 2015/5/17.
 */
//import java.util.*;
public class MinimumWindowSubstringBest {
    boolean minWindow(String S, String T, int minWindowBegin, int minWindowEnd){
        int sLen = S.length();
        int tLen = T.length();
        char[] charT = T.toCharArray();
        char[] charS = S.toCharArray();
        int[] needToFind = new int[256];
        needToFind[0] = 0;
        for(int i = 0; i < tLen; i++){
            needToFind[charT[i]]++;
        }
        int[] hasFound = new int[256];
        hasFound[0] = 0;
        int minWindowLen = Integer.MAX_VALUE;
        int count = 0;
        for(int begin = 0, end = 0; end < sLen; end++){
            if(needToFind[charS[end]] == 0) continue;
            else hasFound[charS[end]]++;
            if(hasFound[charS[end]] <= needToFind[charS[end]]){
                count++;
            }
            if(count == tLen){
                while(needToFind[charS[begin]] == 0 ||
                        hasFound[charS[begin]] > needToFind[charS[begin]] ){
                if(hasFound[charS[begin]] > needToFind[charS[begin]]){
                    hasFound[charS[begin]]--;
                }
                    begin++;
                }
                if(end - begin + 1 < minWindowLen){
                    minWindowBegin = begin;
                    minWindowEnd = end;
                    minWindowLen = end - begin + 1;
                }
            }
        }
        return count == tLen;
    }
}
