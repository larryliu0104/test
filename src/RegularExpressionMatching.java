/**
 * Created by lte on 2015/5/12.
 */
public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        return isMatchRec(s, p, 0, 0);
    }

    public static boolean isMatchRec(String s, String p, int indexS, int indexP) {
        int lenS = s.length();
        int lenP = p.length();

        // we get to the end of the string.
        //�����ַ�����ɱ�������˵��ǰ�涼��ȣ�����true
        //��ط������ܵߵ�����ΪP���ܱ�S����a��ab*����Ҫ�����жϣ��ߵ�������ֱ��false��
        if (indexP == lenP) {
            return indexS == lenS;
        }
        //��Ҫ�ж�2�������
       // 1. ��һ����*����������ʱ����Ҫ����S���ȡ���ΪSΪ��Ҳ�ǿ��Եġ�
        // P���ٻ������ַ���,�����ַ���Ӧ�����ֱ���indexP��indexP + 1������P���¸��ַ���*
        if (indexP < lenP - 1 && p.charAt(indexP + 1) == '*') {
            // ����*����0������ܲ�����ͨ;
            if (isMatchRec(s, p, indexS, indexP + 2)) {//����ֱ�Ӱ�indexP��indexP + 1�����ˣ�������ܺ���Ҳû�£����滹�����ж�
                return true;
            }
            //*������0�������
            //
            for (int i = indexS; i < lenS; i++) {//��������S��P*��ȵĿ���
                // s��p���λ����ȫ��match��Ъ��.
                if (!isMatchChar(s.charAt(i), p.charAt(indexP))) {
                    return false;
                }
               //i= indexSʱ��s*����1�������s��һ����P��2�������ǲ���match�����match��ŶҲ�ˣ���matchҲû�£��¸�ѭ�����һ��S�ٿ���
                //i= indexS+1ʱ����s*����2�������s��1+1����p�����������ǲ���match�����match��ŶҲ�ˣ���match������
                //Sǰ��һλ�������ȣ�������
                if (isMatchRec(s, p, i + 1, indexP + 2)) {//֮����indexP + 2,����ΪindexP + 1��*
                    return true;
                }
            }

            // if any of them does not match, just return false.
            return false;
        }
        //2. ��һ������*�����ͳһ���ǣ���ǰs������������һ���ַ�������У������ݹ鼴�ɡ�
        // match current character and the left string.
        return indexS < lenS
                && isMatchChar(s.charAt(indexS), p.charAt(indexP))
                && isMatchRec(s, p, indexS + 1, indexP + 1);
    }

    public static boolean isMatchChar(char s, char p) {
        if (p == '*') {//p��*Ҳ���У�
            return false;
        }

        if (s == p || p == '.') {
            return true;
        }

        return false;
    }
    	public static void main(String[] args) {
		  System.out.println(isMatch("aa", "a*"));        // true
          System.out.println(isMatch("aa", "a"));     // false
	        System.out.println(isMatch("aa", "aa"));    // true
	        System.out.println(isMatch("aaa", "aa"));   // false
	        System.out.println(isMatch("aa", "a*"));    //true
	        System.out.println(isMatch("aa", ".*"));    // true
	        System.out.println(isMatch("ab", ".*"));    // true
	        System.out.println(isMatch("aab", "c*a*b"));        // true

	        System.out.println(isMatch("", "bab"));         // false
	        System.out.println(isMatch("ab", ".*c"));       // false
	        System.out.println(isMatch("aaa", "a.a"));      // true
	        System.out.println(isMatch("a", "."));          // true
	        System.out.println(isMatch("a", "ab*"));        // true
	        System.out.println(isMatch("bb", ".bab"));      // false
	        System.out.println(isMatch("bb", "*"));         // false
            System.out.println(isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c"));//false
}

}