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

        //��precheck
        // pre-check
        int count = 0;
        for (int i = 0; i < lenp; i++) {
            if (p.charAt(i)!='*') count++;
        }
        if(count > lens) {
            return false;
        }
        // end of pre-check


        // ����һ��Dp��ά����
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

                // if S is empty, P is not empty,��һ����false����ΪP�п�����*
                //������ĳ�����ǰһ��Ϊ�沢��j��*
                if (i == 0) {
                    D[i][j] = D[i][j - 1] && p.charAt(j - 1) == '*';
                } else {//i,j����Ϊ0����ͨ���
                    //�����ֳ������ܻ����ƥ��Ӷ���Dij��Ϊ�棻
                    //һ���Ǵ˴���ĸƥ�䣬��Ȼ����ʺţ�����ǰ����ĸҲƥ��
                    //��һ����p�˴�Ϊ*����άͼ���ϻ�����һ��ΪT�����ΪT����ͼ���Ƚ�������������е㸴�ӣ�
                    D[i][j] = (matchChar(s.charAt(i - 1), p.charAt(j - 1)) && D[i - 1][j - 1])
                            || (p.charAt(j - 1) == '*' && (D[i][j - 1] || D[i - 1][j]));
                }

               // if (D[i][j]) {
              //      flag = true;
              //  }

                // Greedy. �ڴ˼������˳�����Ϊ* ����ƥ�����µ����е��ַ�����
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
