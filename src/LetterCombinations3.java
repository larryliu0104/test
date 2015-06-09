/**
 * Created by lte on 2015/5/14.
 */
import java.util.*;
public class LetterCombinations3 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return ans;

        dfs(ans, new String(), digits.length(), 0,  digits);
        return ans;
    }

    private void dfs(List<String> ans, String subAns, int len, int index, String digits){
        if(subAns.length() == len){
            ans.add(new String(subAns));
            return;
        }
        char[] currentNo = toCharArr(digits.charAt(index));
        for(char temp : currentNo){
            dfs(ans, subAns + temp, len, index + 1, digits);
            //不用回溯是因为加操作在dfs里做的，这样回退回来就是没加的，如果加操作在dfs前就需要回溯，一会写程序调试看下

        }
    }

    private char[] toCharArr(char c){
        switch(c){
            case '0' : return new char[] {};
            case '1' : return new char[] {};
            case '2' : return new char[] {'a', 'b', 'c'};
            case '3' : return new char[] {'d', 'e', 'f'};
            case '4' : return new char[] {'g', 'h', 'i'};
            case '5' : return new char[] {'j', 'k', 'l'};
            case '6' : return new char[] {'m', 'n', 'o'};
            case '7' : return new char[] {'p', 'q', 'r', 's'};
            case '8' : return new char[] {'t', 'u', 'v'};
            case '9' : return new char[] {'w', 'x', 'y', 'z'};
            default : return new char[] {};

        }

    }

    public static void main(String[] args){
        char[] charArr = new char[] {'a', 'b'};
    }
}
