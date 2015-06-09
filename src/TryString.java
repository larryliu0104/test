import java.util.ArrayList;

/**
 * Created by lte on 2015/5/10.
 */
public class TryString {
    public static void main(String[] args){
        String[] i = new String[4];
        i[0] += "Q";
        System.out.println(i[0]);
        String s = "abc";
        System.out.println(s.substring(0, 0) + "hala");
        int j = 1;
        //j.toString();
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        System.out.println(sb);

    }
}
