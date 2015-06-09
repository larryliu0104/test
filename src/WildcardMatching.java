/**
 * Created by lte on 2015/6/6.
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }



        int lens = s.length();
        int lenp = p.length();

        //加precheck
        // pre-check
        int count = 0;
        for (int i = 0; i < lenp; i++) {
            if (p.charAt(i)!='*') count++;
        }
        if(count > lens) {
            return false;
        }
        // end of pre-check


        // 创建一个Dp二维数组
        boolean[][] D = new boolean[lens + 1][lenp + 1];

        //boolean flag = false;

        for (int i = 0; i <= lens; i++) {
            //flag = false;
            for (int j = 0; j <= lenp; j++) {
                // both is empty.
                if (i == 0 && j == 0) {
                    D[i][j] = true;
                    //flag = true;
                    continue;
                }

                // if P is empty, s is not empty, it is false.
                if (j == 0) {
                    D[i][j] = false;
                    continue;
                }

                // if S is empty, P is not empty,不一定是false，因为P有可能是*
                //返回真的场景是前一个为真并且j是*
                if (i == 0) {
                    D[i][j] = D[i][j - 1] && p.charAt(j - 1) == '*';
                } else {//i,j都不为0的普通情况
                    //有两种场景可能会完成匹配从而把Dij置为真；
                    //一种是此处字母匹配，相等或有问号，并且前面字母也匹配
                    //另一种是p此处为*，二维图里上或左右一个为T这里就为T，画图看比较清楚，想起来有点复杂；
                    D[i][j] = (matchChar(s.charAt(i - 1), p.charAt(j - 1)) && D[i - 1][j - 1])
                            || (p.charAt(j - 1) == '*' && (D[i][j - 1] || D[i - 1][j]));
                }

               // if (D[i][j]) {
              //      flag = true;
              //  }

                // Greedy. 在此即可以退出，因为* 可以匹配余下的所有的字符串。
                //if (D[i][j] && p.charAt(j - 1) == '*' && j == lenp) {
                //    return true;
                //}
            }

           // if (!flag) {
            //    return false;
           // }
        }

        return D[lens][lenp];
    }

    public static boolean matchChar(char c, char p) {
        return (p == '?' || p == c);
    }

    public static void main(String[] args){
        System.out.println(new WildcardMatching().isMatch("abcd", "?b*"));
    }
}
