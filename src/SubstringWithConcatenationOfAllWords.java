/**
 * Created by lte on 2015/6/8.
 */
import java.util.*;
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        List<Integer> ans = new ArrayList<Integer>();

        if(s == null || words == null) return ans;

        for(String str : words){//�Ѵ���������words���Ͻ�hashmap
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);//get�Ҳ�������null��������0������if��else���ܺϲ�
            }else{
                map.put(str, 1);
            }
        }

        int isFound = 0;
        int wordL = words[0].length();
        for(int i = 0; i < s.length() - wordL * words.length; i++){//ע��߽�����
            found.clear();//�������
            isFound = 0;
            for(int j = i; j < s.length() - wordL; j += wordL){
                String temp = s.substring(j, j + wordL);
                if(map.containsKey(temp)){
                    if(found.containsKey(temp)){
                        if(found.get(temp) == map.get(temp)){//found�Ѿ������ˣ����ð�ˣ�����
                            break;
                        }else{//foundû�������ӽ���
                            found.put(temp, found.get(temp) + 1);
                        }
                    }else{//found�ﻹû�У�map�У��ӽ���
                        found.put(temp, 1);
                    }
                }else{//map��û��
                    break;
                }

                if(found.get(temp) == map.get(temp)){//����֮�����ˣ��ҵ����ʼ�1
                    isFound++;
                }

                if(isFound == map.size()){
                    ans.add(i);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args){
        String s = "a";
        String[] words = {"a"};
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s, words));
    }
}
