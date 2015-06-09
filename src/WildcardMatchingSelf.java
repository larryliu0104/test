/**
 * Created by lte on 2015/6/6.
 */
public class WildcardMatchingSelf {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        }
        int lenS = s.length();
        int lenP = p.length();
        //预判断，p的有效字符比s长一定是false，不做这个提交空间复杂度会超限
        int count = 0;
        for(int i = 0; i < lenP; i++){
            if(p.charAt(i) != '*'){
                count++;
            }
        }
        if(count > lenS){
            return false;
        }

        //用二维动态规划判断是否match，
        boolean[][] DP = new boolean[lenS + 1][lenP + 1];
        for(int i = 0; i <= lenS; i++)
            for(int j = 0; j <= lenP; j++){
                if(i == 0 && j == 0){
                    //对应两个空字符串；
                    DP[i][j] = true;
                }else if(i == 0){
                    //s为空，p非空，此处为真的条件是上一个为真并且此处是星号
                    DP[i][j] = (DP[i][j - 1] && p.charAt(j - 1) == '*');
                }else if(j == 0){
                    //s非空，p为空，一定为假
                    DP[i][j] = false;

                }else{//s，p都非空，有两个情况此处可以为真
                    //1是此处值相等并且左上角为真，左上角为真代表除了此处的值，俩字符串相等
                    DP[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && (DP[i - 1][j - 1] == true) ||
                            //2是，p此处为星号，并且上或左为真，这里画图能看的比较清楚
                            (p.charAt(j - 1) == '*' && (DP[i][j - 1] || DP[i - 1][j]));
                }
            }
        return DP[lenS][lenP];
    }
    public static void main(String[] args){
        System.out.println(new WildcardMatchingSelf().isMatch("aa", "aa"));
    }
}
