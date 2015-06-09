/**
 * Created by lte on 2015/6/4.
 */
import java.util.*;
public class MergeIntervals2 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0){
            return ans;
        }
        //把intervals按start排序，这里用了匿名类重写了Comparator的compare方法，??的
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        Interval last = intervals.get(0);
        Iterator<Interval> iter = intervals.iterator();
        while(iter.hasNext()){//这里只返回布尔值不前进
            Interval current = iter.next();//这里前进
            if(current.start > last.end){//可以剥离current和last
                ans.add(last);
                last = current;
            }else{//不能剥离
                last = new Interval(last.start, Math.max(current.end, last.end));
            }
        }
        ans.add(last);//加入末尾的区间
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
        System.out.println(new MergeIntervals2().merge(intervals));
    }
}
