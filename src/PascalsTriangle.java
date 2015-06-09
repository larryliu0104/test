import java.util.ArrayList;
import java.util.List;

/**
 * Created by lte on 2015/5/24.
 */

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(numRows <= 0) return ans;
        for(int i = 0; i < numRows; i++){
            List<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    temp.add(1);
                }else{
                    temp.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(temp);
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(new PascalsTriangle().generate(3));
    }
}
