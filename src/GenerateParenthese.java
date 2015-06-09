/**
 * Created by lte on 2015/5/14.
 */
import java.util.*;
public class GenerateParenthese {

        public List<String> generateParenthesis(int n) {
            List<String> ret = new ArrayList<String>();

            if (n == 0) {
                return ret;
            }

            dfs(n, n, new String(), ret);

            return ret;
        }

        // left : the left Parentheses
        // right : the right Parentheses
        public void dfs(int left, int right, String sb, List<String> ret) {
            if (left == 0 && right == 0) {
                ret.add(sb);
                return;
            }

            // left < right means that we have more ( then we can add ).
            if (left < 0 || right < 0 || left > right) {
                return;
            }

            dfs(left - 1, right, sb + '(', ret);//删除不是为了回溯，是为了去掉多加的括号？
            //if(sb.length() > 0) {
                //System.out.println(sb);
              //  sb = sb.substring(0, sb.length() - 1);//卧槽，这里回溯不回溯结果居然是一样的;傻逼了，没写sb等于,这里不需要回溯
           // }

            dfs(left, right - 1, sb + ')', ret);
           // if(sb.length() > 0){
                //System.out.println(sb);
             //   sb = sb.substring(0, sb.length() - 1);
            //}
        }
    public static void main(String[] args){
        System.out.println(new GenerateParenthese().generateParenthesis(3));
    }

}