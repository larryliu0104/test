/**
 * Created by lte on 2015/5/17.
 */
import java.util.*;
public class MimimumWindowSubstring {
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> toBeFound = new HashMap<Character, Integer>();
        HashMap<Character, Integer> isFound = new HashMap<Character, Integer>();
        for (Character ch: T.toCharArray()) {//��ʼ�������Һ����ҵ�Hashmap
            if (toBeFound.containsKey(ch)) {//����������ַ������ظ�����������ifѭ��
                toBeFound.put(ch, toBeFound.get(ch) + 1);//���ظ�˵���������Ѿ�������һ���ˣ��������Ӵ����Ҽ�����
            } else {//���ظ��������
                toBeFound.put(ch, 1);//�����Ǵ�����1����
                isFound.put(ch, 0);//���������ҵ�0����
            }
        }
        int count = 0;//�ҵ��������ַ��ļ���
        int currentMinWinStart = 0;
        int currentMinWinEnd = 0;
        String result = "";
        while (currentMinWinEnd < S.length()) {
            char cur = S.charAt(currentMinWinEnd);
            if (!toBeFound.containsKey(cur)) {//Ŀǰ�ַ�û����ǰ������ǰ������
                currentMinWinEnd++;
                continue;
            }
            isFound.put(cur, isFound.get(cur) + 1);//�ҵ��˸�isFound��λ��index��1
            if (isFound.get(cur) <= toBeFound.get(cur)) {//�����ҵ��������ҵ��������õģ����ҵ�������1����������Ҫ��aaaaab����ab��2-4��a������ʱû�õ�
                count++;
            }

            if (count == T.length()) {
                // locate start point
                while(true) {
                    char tempStart = S.charAt(currentMinWinStart);
                    if (!toBeFound.containsKey(tempStart)) {//���ʹ������ַ��޹أ�������ǰ�ƺ���
                        currentMinWinStart++;
                        continue;
                    }
                    if (isFound.get(tempStart) > toBeFound.get(tempStart)) {//�ҵ��ĸ����ȴ����Ҹ����࣬���Կ����ƶ�������
                        isFound.put(tempStart, isFound.get(tempStart) - 1);//�ҵ�������1����������һλ��
                        currentMinWinStart++;
                        continue;
                    } else {//�������ַ����ж��Ѿ����ȴ����Ҷ࣬���ھͲ�����ǰ���ˣ�ǰ�ƾ�ȱԪ����
                        break;
                    }
                }
                if (result.equals("") || result.length() > currentMinWinEnd - currentMinWinStart + 1) {//���Ϊ�մ󵨸��£�������¼���ĳ���ҲҪ���³ɸ��̵�
                    result = S.substring(currentMinWinStart, currentMinWinEnd + 1);
                }
            }
            currentMinWinEnd++;
        }
        return result;
    }

    public static void main(String[] args){
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String S1 = "acbbaca";
        String T1 = "aba";
       // System.out.println(new MimimumWindowSubstring().minWindow(S, T));
        System.out.println(new MimimumWindowSubstring().minWindow(S1, T1));
    }
}
