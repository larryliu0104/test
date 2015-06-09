import java.util.List;

/**
 * Created by lte on 2015/5/10.
 */
import java.util.*;
public class NQueens2 {
    public List<String[]> solveNQueens(int n) {
        List<String[]> ans = new ArrayList<String[]>();

        dfs(n, ans, new ArrayList<Integer>());
        return ans;
    }
    private void dfs(int n, List<String[]> ans, ArrayList<Integer> queenPosition){
        if(queenPosition.size() == n){
            String[] temp = changeToStringAns(queenPosition);
            System.out.println(queenPosition);
            ans.add(temp);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!isValid(queenPosition, i)){
                continue;
            }
            queenPosition.add(i);
            dfs(n, ans, queenPosition);
            queenPosition.remove(queenPosition.size() - 1);
        }
    }
    private String[] changeToStringAns(ArrayList<Integer> queenPosition){
        int size = queenPosition.size();
        String[] ans = new String[size];
        for(int i = 0; i < size; i++){
            ans[i] = new String();
            for(int j = 0; j < size; j++) {
                if (queenPosition.get(i) == j) {
                    ans[i] += "Q";
                } else {
                    ans[i] += ".";
                }
            }
            }
        return ans;
    }

    private boolean isValid(ArrayList<Integer> queenPosition, int newQueenPosition){
        int totalCurrentRow = queenPosition.size();
        for(int currentRow = 0; currentRow < totalCurrentRow; currentRow++){
            if(queenPosition.get(currentRow) == newQueenPosition){//ÅÐ¶ÏÁÐ
                return false;
            }
            //ÅÐ¶Ï¶Ô½ÇÏß£»
            if((totalCurrentRow - currentRow) == Math.abs(newQueenPosition - queenPosition.get(currentRow))){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        List<String[]> ans = new NQueens2().solveNQueens(4);
        for(String[] temp : ans){
            for(String temp1 : temp)
            System.out.println(temp1);
        }

    }
}
