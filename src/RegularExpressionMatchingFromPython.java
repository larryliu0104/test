/**
 * Created by lte on 2015/5/13.
 */
public class RegularExpressionMatchingFromPython {
    /*
     def isMatch(self, s, p):
        if p == '':
            return s == ''

        if len(p) == 1:
            if len(s) == 1:
                return s[0] == p[0] or p[0] == '.'
            return False

        if p[1] != '*':
            if s[0] == p[0] or p[0] == '.':
                if len(s) > 1:
                    return self.isMatch(s[1:], p[1:])
            return False
        */
    public static boolean isMatch(String s, String p) {
        if (p == "")
            return s == "";
        int lenS = s.length();
        int lenP = p.length();
        if (lenP == 1) {//如果长度为1
            if (lenS == 1) {
                return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
            }
            return false;
        }

        if(s == ""){
            while(p.charAt(1) == '*') return isMatch(s, p + 2);
            return false;
        }

        if (p.charAt(1) != '*') {//长度不为1，p后面不是*
            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
                if (lenS > 1 || (lenP > 2 && p.charAt(2) == '*')) {//加了一个判断
                    return isMatch(s.substring(1), p.substring(1));
                }

            }
            return false;
        }

    /*
        j = 0
        while j < len(s) and (s[j] == p[0] or p[0] == '.'):
            if len(p) > 2 and self.isMatch(s[j:], p[2:]):
                return True
            j += 1

        if len(s) == j and len(p) == 2:
            return True
        elif len(s) == j or len(p) == 2:
            return False
        return self.isMatch(s[j:], p[2:])
     */
        int j = 0;//长度不为1，p后面是*
        while (j < lenS && (s.charAt(j) == p.charAt(0) || p.charAt(0) == '.')) {
            if(lenP > 2 && isMatch(s.substring(j), p.substring(2))){//*是0的情况？但前面while排除了a, ab*这种？
                return true;
            }
            j += 1;
        }
        if(lenS == j && lenP == 2) return true;
        else if(lenS == j || lenP == 2) return false;

        return isMatch(s.substring(j), p.substring(2));
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
        System.out.println(isMatch("a", "."));          // true
        System.out.println(isMatch("a", "ab*"));        // true
        System.out.println(isMatch("bb", ".bab") == false);      // false
        System.out.println(isMatch("bb", "*") == false);         // false
        System.out.println(isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c") == false);

        System.out.println(isMatch("a", ""));
    }

}
