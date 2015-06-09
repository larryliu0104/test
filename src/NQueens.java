import java.util.*;
public class NQueens {
    public List<String[]> solveNQueens(int n) {
        List<String[]> ret = new ArrayList<String[]>();

        if (n == 0) {
            return ret;
        }

        dfs(n, new ArrayList<Integer>(), ret);
        return ret;
    }

    public String[] createSolution(ArrayList<Integer> queenPosition) {
        /*
        [
         [".Q..",  // Solution 1
          "...Q",
          "Q...",
          "..Q."],
        
         ["..Q.",  // Solution 2
          "Q...",
          "...Q",
          ".Q.."]
        ]
        */
        int size = queenPosition.size();
        String[] ret = new String[size];

        for (int i = 0; i< size; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < size; j++) {
                // a queen.
                if (j == queenPosition.get(i)) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }

            ret[i] = sb.toString();
        }

        return ret;
    }

    //ArrayList<Integer> path: store the index of the columns of one solution.
    private void dfs(int n, ArrayList<Integer> path, List<String[]> ret) {
        if (path.size() == n) {
            System.out.println(path);
            String[] solution = createSolution(path);
            ret.add(solution);
            return;
        }

        for (int i = 0; i < n; i++) {
            // Judge if this is a solution;
            if (!isValid(path, i)) {
                continue;
            }

            path.add(i);
            dfs(n, path, ret);
            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(ArrayList<Integer> queenPosition, int currentQueenColumn) {
        int totalCurrentRow = queenPosition.size();//path应该是n个数字，每个数字代表这行的这个地方放皇后
        for (int row = 0; row < totalCurrentRow; row++) {//从0到size-1扫描，如果path有任意一个值和index相等，说明这一列还有皇后，放弃
            // Same column as one queen.
            if (currentQueenColumn == queenPosition.get(row)) {
                return false;
            }

            // 在两条对角线之上
            // bug 3: 少一个)
            if (totalCurrentRow - row == Math.abs(currentQueenColumn - queenPosition.get(row))) {
                //这里size是此时path中元素个数，可以理解成行？size-i是差几行，差1行斜线就差一列，差两行就差两列
                //右边是此时要放的皇后和第i行的皇后差几列
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args){
        List<String[]> ans = new NQueens().solveNQueens(4);
        for(String[] temp : ans){
            for(String temp1 : temp)
                System.out.println(temp1);
        }

    }
}