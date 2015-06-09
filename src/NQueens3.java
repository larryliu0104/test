/**
 * Created by lte on 2015/5/12.
 */
import java.util.*;
public class NQueens3 {
    public int totalNQueens(int n) {
        int totalSolution = 0;
        ArrayList<List<Integer>> solution = new ArrayList<List<Integer>>();
        ArrayList<Integer> subSolution = new ArrayList<Integer>();
        dfs(n, totalSolution, subSolution, solution);
        System.out.println(totalSolution);
        return solution.size();
    }
    private void dfs(int n, int totalSolution, ArrayList<Integer> subSolution, ArrayList<List<Integer>> solution){
        if(subSolution.size() == n){
            solution.add(subSolution);
            System.out.println(subSolution);
            totalSolution++;
            return;
        }
        for(int i = 0; i < n; i++){
            if(!isValid(subSolution, i)){
                continue;
            }
            subSolution.add(i);
            dfs(n, totalSolution, subSolution, solution);
            subSolution.remove(subSolution.size() - 1);
        }

    }
    private boolean isValid(ArrayList<Integer> subSolution, int newColumn){
        int currentRow = subSolution.size();
        for(int i = 0; i < currentRow; i++){
            if(subSolution.get(i) == newColumn){//ÁÐ
                return false;
            }
            if(currentRow - i == Math.abs(newColumn - subSolution.get(i))){//¶Ô½ÇÏß
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(new NQueens3().totalNQueens(4));
    }
}
