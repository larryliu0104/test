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
        //Ԥ�жϣ�p����Ч�ַ���s��һ����false����������ύ�ռ临�ӶȻᳬ��
        int count = 0;
        for(int i = 0; i < lenP; i++){
            if(p.charAt(i) != '*'){
                count++;
            }
        }
        if(count > lenS){
            return false;
        }

        //�ö�ά��̬�滮�ж��Ƿ�match��
        boolean[][] DP = new boolean[lenS + 1][lenP + 1];
        for(int i = 0; i <= lenS; i++)
            for(int j = 0; j <= lenP; j++){
                if(i == 0 && j == 0){
                    //��Ӧ�������ַ�����
                    DP[i][j] = true;
                }else if(i == 0){
                    //sΪ�գ�p�ǿգ��˴�Ϊ�����������һ��Ϊ�沢�Ҵ˴����Ǻ�
                    DP[i][j] = (DP[i][j - 1] && p.charAt(j - 1) == '*');
                }else if(j == 0){
                    //s�ǿգ�pΪ�գ�һ��Ϊ��
                    DP[i][j] = false;

                }else{//s��p���ǿգ�����������˴�����Ϊ��
                    //1�Ǵ˴�ֵ��Ȳ������Ͻ�Ϊ�棬���Ͻ�Ϊ�������˴˴���ֵ�����ַ������
                    DP[i][j] = (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') && (DP[i - 1][j - 1] == true) ||
                            //2�ǣ�p�˴�Ϊ�Ǻţ������ϻ���Ϊ�棬���ﻭͼ�ܿ��ıȽ����
                            (p.charAt(j - 1) == '*' && (DP[i][j - 1] || DP[i - 1][j]));
                }
            }
        return DP[lenS][lenP];
    }
    public static void main(String[] args){
        System.out.println(new WildcardMatchingSelf().isMatch("aa", "aa"));
    }
}
