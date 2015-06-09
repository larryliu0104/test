import java.util.*;
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        dfs(n, ans, 0, 0, new String());
        return ans;
    }
    private void dfs(int n, List<String> ans, int leftPar, int rightPar, String subList){
        //if(leftPar > 3) return;
        if(leftPar == n && rightPar == n){
            ans.add(new String(subList));
            return;
        }

        for(int i = leftPar; i < n; i++){
            //subList += "(";
            dfs(n, ans, leftPar + 1, rightPar, subList + "(");
            //subList = subList.substring(0, subList.length() - 1);

        }
        if(leftPar > rightPar){
            //subList += ")";
            dfs(n, ans, leftPar, rightPar + 1, subList + ")");
        }
        //subList = subList.substring(0, subList.length() - 1);


    }
    public static void main(String[] args){
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}