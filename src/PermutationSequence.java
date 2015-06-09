import java.io.SyncFailedException;
import java.util.ArrayList;

/**
 * Created by lte on 2015/5/24.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        ArrayList<String> ans = new ArrayList<String>();
        dfs(n,  new StringBuilder(), ans, new boolean[n]);
        System.out.println(ans);
        return ans.get(k - 1);
    }
    //标准的递归加回溯，可不可以到了k就停止？
    private void dfs(int n,  StringBuilder subAns, ArrayList<String> ans, boolean[] isVisited){
        if(subAns.length() == n){
            ans.add(subAns.toString());//不需要new，因为string每次改变都是新的object
            return;
        }
        for(int i = 1; i <= n; i++){
            if(!isVisited[i - 1]) {
                subAns.append(i);
                isVisited[i - 1] = true;
                dfs(n, subAns, ans, isVisited);
                subAns.deleteCharAt(subAns.length() - 1);
                isVisited[i - 1] = false;
            }
        }
    }
    public static void main(String[] args){
        long t0 = System.currentTimeMillis();
        System.out.println(new PermutationSequence().getPermutation(9, 24));
        long t1 = System.currentTimeMillis();
        System.out.println(t1-t0);
    }
}
