/**
 * Created by lte on 2015/6/3.
 */
import java.util.*;
public class MergeIntervals {
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            return ans;
        }
        //�Ȱ�start����
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        //�ж��Ƿ���Ҫ�ϲ�
        Interval last = intervals.get(0);
        Iterator<Interval> iter = intervals.iterator();
        while(iter.hasNext()){
            Interval current = iter.next();
            if(current.start < last.end){//�ֿܷ�������ϲ���
                ans.add(last);
                last = current;
            }else{//�ֲ�������Ҫ�ϲ�
                int s = last.start;
                int e = Math.max(last.end, current.end);
                last = new Interval(s, e);
            }
        }
        ans.add(last);
        return ans;
    }
     public static class Interval {
             int start;
             int end;
            Interval() { start = 0; end = 0; }
             Interval(int s, int e) { start = s; end = e; }
         }
    public static void main(String[] args){
        Interval i = new Interval(1,3);
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i);
        System.out.println(merge(intervals));
    }
}
