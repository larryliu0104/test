/**
 * Created by lte on 2015/5/13.
 */
import java.util.*;
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            ans.add("");
            return ans;
        }
        int len = digits.length();
        // this type of DFS question is very standardized
        helper(ans, "", digits, 0, len);
        return ans;
    }

    private void helper(List<String> ans, String path, String digits, int pos, int len) {
        if (pos == len) {
            ans.add(path);
            return;
        }
        // check the char at position 'pos', and find all possible letters to insert
        String possibleLetters = getLetters(digits.charAt(pos));
        for (char letter: possibleLetters.toCharArray()) {
            helper(ans, path + letter, digits, pos + 1, len);
        }
    }

    private String getLetters(char digit) {
        // first convert char to integer
        int index = digit - '0';
        String[] map = new String[] {
                " ",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        // second, find corresponding string from map
        return map[index];
    }
    public  static void main(String[] args){
        System.out.println(new LetterCombinations().letterCombinations("234"));
    }
}
