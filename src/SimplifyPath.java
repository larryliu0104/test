/**
 * Created by lte on 2015/5/21.
 */
import java.util.*;
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] list = path.split("/");
        for(String cur: list) {
            if (cur.equals("/") || cur.equals(".")
                    || cur.equals("")) continue;
            if (cur.equals("..")) {
                if (! stack.isEmpty()) stack.pop();
            } else stack.push(cur);
        }
        String ans = "";
        if (stack.isEmpty()) return "/";
        while (! stack.isEmpty()) {
            ans = "/" + stack.pop() + ans;
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(new SimplifyPath().simplifyPath("."));
    }
}
