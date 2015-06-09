/**
 * Created by lte on 2015/5/17.
 */
import java.util.*;
public class TextJustificationSelf {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();
        if(words == null){
            return ans;
        }
        int len = words.length;
        int beginIndex = 0;//the begin index of the comming line
        int endIndex = 0;
        while(endIndex < len){
            //endIndex = beginIndex;
            int tempWidth = maxWidth;
            for(int i = beginIndex; endIndex < len && words[i].length() <= tempWidth; endIndex++, i++){//count the words
                //String wordTemp = words[i];
                tempWidth -= words[i].length();
                tempWidth--;//space following
            }

            tempWidth++;//add the last space that is not exist;
            int wordNum = endIndex - beginIndex;//endIndex is 1 bigger than the fact because of the last ++
            int avgSpace = 0;
            int extraSpace = 0;
            if(wordNum > 1) {
                avgSpace = tempWidth / (wordNum - 1);
                extraSpace = tempWidth % (wordNum - 1);
            }
            StringBuilder thisLine = new StringBuilder();
            if(wordNum == 1){//only one word
                thisLine.append(words[beginIndex]);
                spaceAppend(thisLine, tempWidth);
            }else if(endIndex == len){//last line;
                for(int i = beginIndex; i < endIndex; i++){
                    if(i != endIndex - 1){//i is not the last word
                        thisLine.append(words[i]);
                        thisLine.append(" ");
                    }else{
                        thisLine.append(words[i]);
                        spaceAppend(thisLine, tempWidth);
                    }
                }
            }else{//other situation

                for(int i = beginIndex; i < endIndex; i++){
                    thisLine.append(words[i]);
                    if(i != endIndex - 1) {
                        int thisLineSpace = avgSpace;
                        if (extraSpace > 0) {
                            extraSpace--;
                            thisLineSpace++;
                        }
                        spaceAppend(thisLine, thisLineSpace + 1);
                    }
                }
            }
            beginIndex = endIndex;
            ans.add(thisLine.toString());
            System.out.println(ans);
        }
        return ans;
    }

    private void spaceAppend(StringBuilder thisLine, int thisLineSpace){
        while(thisLineSpace > 0){
            thisLine.append(" ");
            thisLineSpace--;
        }
    }

    public static void main(String[] args){
        String[] words = {"This", "is", "and", "an", "example", "of", "text", "justification", "and", "it", "is", "quite", "funny", "haha"};
        int L = 16;
        System.out.println(new TextJustificationSelf().fullJustify(words, L));
    }
}
