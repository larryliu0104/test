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

            dfs(left - 1, right, sb + '(', ret);//ɾ������Ϊ�˻��ݣ���Ϊ��ȥ����ӵ����ţ�
            //if(sb.length() > 0) {
                //System.out.println(sb);
              //  sb = sb.substring(0, sb.length() - 1);//�Բۣ�������ݲ����ݽ����Ȼ��һ����;ɵ���ˣ�ûдsb����,���ﲻ��Ҫ����
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