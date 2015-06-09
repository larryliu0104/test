/**
 * Created by lte on 2015/5/14.
 */
import java.util.*;
public class LetterCombinations2 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if(digits == null) return ans;
        dfs(ans, new String(), 0, digits.length(), digits);
        return ans;
    }

    private void dfs(List<String> ans, String subAns, int index, int len, String digits){
        if(subAns.length() == len){
            ans.add(new String(subAns));
            return;
        }
        String toCom = toStr(digits.charAt(index));
        for(char temp : toCom.toCharArray()){
            subAns += temp;
            dfs(ans, subAns, index + 1, len, digits);
          // if(subAns.length() > 0) {
           //    subAns = subAns.substring(0, subAns.length() - 1);

           //}
        }
    }

    private String toStr(char c){
        switch(c){
            case '0': return "";
            case '1': return "";
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            default: return "";
        }
    }

    public  static void main(String[] args){
        System.out.println(new LetterCombinations2().letterCombinations("234"));
    }
}
