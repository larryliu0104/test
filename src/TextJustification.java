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
        int index = 0;//某行结束后下一个单词的索引

        while (index < len) {
            int LenTmp = L;

            int end = index;
            for (int i = index; i < len && words[i].length() <= LenTmp; i++) {//判断一行能放几个字符串
                LenTmp -= words[i].length();

                // the space follow the word.
                LenTmp--;
                end = i;
            }

            // 最后一个空格收回,因为最后一个单词要顶格
            LenTmp++;//剩余的位置，用来放单词，如果单词放不下则放多余的空格；

            // 这行有几个单词
            int num = end - index + 1;

            int extraSpace = 0;//不靠尾单词后的空格（没算默认那个）
            int firstExtra = 0;//第一个单词后多余的空格

            // 单词数大于1，才需要分配，否则所有的空格加到最后即可
            if (num > 1) {
                extraSpace = LenTmp / (num - 1);//剩余的空格平均取整分给每个不靠尾的单词；
                // 首单词后多跟的空格
                firstExtra = LenTmp % (num - 1);//余的零头;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = index; i <= end; i++) {//加这行的单词
                sb.append(words[i]);

                int cnt = 0;

                if (i == end) {//到末尾就不要加空格啦，这行完成任务直接跳出
                    break;
                }

                // 不是最后一行
                if (end != len - 1) {//最后一行不做这个justification操作
                    // The first words.
                    if (firstExtra > 0) {//余的零头如果大于0，给一个，因为它一定小于单词见的间隔，这样处理就优先分给靠左的单词后面了
                        cnt++;
                        firstExtra--;
                    }

                    // 最后一个单词后面不需要再加空格
                    // 每个单词后的额外空格
                    cnt += extraSpace;
                }

                // 1: 每个单词后本来要加的空格
                appendSpace(sb, cnt + 1);//cnt是额外空格，1是本来单词后面的空格
            }

            // 最后一行的尾部的空格，或者是只有一个单词的情况
            appendSpace(sb, L - sb.length());

            ret.add(sb.toString());//添加处理好的某行
            index = end + 1;//index更新继续下一行
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
