/**
 * Created by lte on 2015/5/13.
 */
public class RegularExpressionMatching2 {
    public static boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int lenS = s.length();
        int lenP = p.length();
        return recursion(s, p, 0, 0, lenS, lenP);
    }

    private static boolean recursion(String s, String p, int indexS, int indexP, int lenS, int lenP){
        if(lenP == indexP)//�ݹ����������Ҫ���ж�P,��ΪP�ĳ��ȴ��ڵ���s��˵��s��ͷ��p��һ����ͷ
            return lenS == indexS;

        if(indexP + 1 < lenP && p.charAt(indexP + 1) == '*'){
            if(recursion(s, p, indexS, indexP + 2, lenS, lenP))//P*����0
                return true;
            for(int i = indexS; i < lenS; i++){//P*����0��indexS��indexP��Ӧ�����
                if(!isEqual(s.charAt(i), p.charAt(indexP))){
                    return false;
                }
                if(recursion(s, p, i + 1, indexP, lenS, lenP)){
                    return true;
                }

            }
            return false;
        }
        if( indexS < lenS && isEqual(s.charAt(indexS), p.charAt(indexP)) && recursion(s, p, indexS + 1, indexP + 1, lenS, lenP)){
            return true;
        }else{
            return false;
        }
    }

    private static boolean isEqual(char s, char p){
        if(s == p || p == '.') return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));        // true
        System.out.println(isMatch("aa", "a") == false);     // false
        System.out.println(isMatch("aa", "aa"));    // true
        System.out.println(isMatch("aaa", "aa") == false);   // false
        System.out.println(isMatch("aa", "a*"));    //true
        System.out.println(isMatch("aa", "bb") == false);    //true
        System.out.println(isMatch("aa", ".*"));    // true
        System.out.println(isMatch("ab", ".*"));    // true
        System.out.println(isMatch("aab", "c*a*b"));        // true

        System.out.println(isMatch("", "bab") == false);         // out of range
        System.out.println(isMatch("ab", ".*c") == false);       // false
        System.out.println(isMatch("aaa", "a.a"));      // true
        System.out.println(isMatch("a", ".") + "aoao");          // true
        System.out.println(isMatch("a", "ab*") + "aoao");        // true
        System.out.println(isMatch("bb", ".bab") == false);      // false
        System.out.println((isMatch("bb", "*") == false) + "wuaoao");         // false
        System.out.println(isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c") == false);

        System.out.println(isMatch("a", ""));
    }
}
