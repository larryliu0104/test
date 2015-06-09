/**
 * Created by lte on 2015/5/17.
 */
import java.util.*;
public class TextJustification {
    // SOLUTION 3: iteration2
    public List<String> fullJustify(String[] words, int L) {
        List<String> ret = new ArrayList<String>();
        if (words == null) {
            return ret;
        }

        int len = words.length;
        int index = 0;//ĳ�н�������һ�����ʵ�����

        while (index < len) {
            int LenTmp = L;

            int end = index;
            for (int i = index; i < len && words[i].length() <= LenTmp; i++) {//�ж�һ���ܷż����ַ���
                LenTmp -= words[i].length();

                // the space follow the word.
                LenTmp--;
                end = i;
            }

            // ���һ���ո��ջ�,��Ϊ���һ������Ҫ����
            LenTmp++;//ʣ���λ�ã������ŵ��ʣ�������ʷŲ�����Ŷ���Ŀո�

            // �����м�������
            int num = end - index + 1;

            int extraSpace = 0;//����β���ʺ�Ŀո�û��Ĭ���Ǹ���
            int firstExtra = 0;//��һ�����ʺ����Ŀո�

            // ����������1������Ҫ���䣬�������еĿո�ӵ���󼴿�
            if (num > 1) {
                extraSpace = LenTmp / (num - 1);//ʣ��Ŀո�ƽ��ȡ���ָ�ÿ������β�ĵ��ʣ�
                // �׵��ʺ����Ŀո�
                firstExtra = LenTmp % (num - 1);//�����ͷ;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = index; i <= end; i++) {//�����еĵ���
                sb.append(words[i]);

                int cnt = 0;

                if (i == end) {//��ĩβ�Ͳ�Ҫ�ӿո����������������ֱ������
                    break;
                }

                // �������һ��
                if (end != len - 1) {//���һ�в������justification����
                    // The first words.
                    if (firstExtra > 0) {//�����ͷ�������0����һ������Ϊ��һ��С�ڵ��ʼ��ļ����������������ȷָ�����ĵ��ʺ�����
                        cnt++;
                        firstExtra--;
                    }

                    // ���һ�����ʺ��治��Ҫ�ټӿո�
                    // ÿ�����ʺ�Ķ���ո�
                    cnt += extraSpace;
                }

                // 1: ÿ�����ʺ���Ҫ�ӵĿո�
                appendSpace(sb, cnt + 1);//cnt�Ƕ���ո�1�Ǳ������ʺ���Ŀո�
            }

            // ���һ�е�β���Ŀո񣬻�����ֻ��һ�����ʵ����
            appendSpace(sb, L - sb.length());

            ret.add(sb.toString());//��Ӵ���õ�ĳ��
            index = end + 1;//index���¼�����һ��
        }

        return ret;
    }

    public void appendSpace(StringBuilder sb, int cnt) {
        while (cnt > 0) {
            sb.append(' ');
            cnt--;
        }
    }

    public static void main(String[] args){
        String[] words = {"This", "is", "and", "an", "example", "of", "text", "justification", "and", "it", "is", "quite", "funny", "haha"};
        int L = 16;
        System.out.println(new TextJustification().fullJustify(words, L));
    }

}
