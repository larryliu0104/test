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
        int totalCurrentRow = queenPosition.size();//pathӦ����n�����֣�ÿ�����ִ������е�����ط��Żʺ�
        for (int row = 0; row < totalCurrentRow; row++) {//��0��size-1ɨ�裬���path������һ��ֵ��index��ȣ�˵����һ�л��лʺ󣬷���
            // Same column as one queen.
            if (currentQueenColumn == queenPosition.get(row)) {
                return false;
            }

            // �������Խ���֮��
            // bug 3: ��һ��)
            if (totalCurrentRow - row == Math.abs(currentQueenColumn - queenPosition.get(row))) {
                //����size�Ǵ�ʱpath��Ԫ�ظ��������������У�size-i�ǲ�У���1��б�߾Ͳ�һ�У������оͲ�����
                //�ұ��Ǵ�ʱҪ�ŵĻʺ�͵�i�еĻʺ���
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