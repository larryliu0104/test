/**
 * Created by lte on 2015/5/14.
 */
import java.util.*;
public class GenerateParenthese2 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        if (n == 0) {
            return ans;
        }
        helper(ans, "", n, n);
        return ans;
    }

    private void helper(List<String> ans, String path, int left, int right) {
        if (left == 0 && right == 0) {
            ans.add(path);
            return;
        }
        // add either left or right parenthese
        if (left > 0) {
            helper(ans, path + "(", left - 1, right);
        }
        if (right > left) {
            helper(ans, path + ")", left, right - 1);
        }
    }

    public static void main(String[] args){
        System.out.println(new GenerateParenthese2().generateParenthesis(3));
    }
}
