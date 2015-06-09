import java.util.ArrayList;
import java.util.*;

/**
 * Created by lte on 2015/6/6.
 */
public class InsertIntervals {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals == null) return result;
        intervals.add(newInterval);

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        int newIntervalStart = newInterval.start;
        Iterator<Interval> iter = intervals.iterator();
        Interval last = intervals.get(0);
        while(iter.hasNext()){//iterator是在哪里前进的？
            Interval current = iter.next();
            if(last.end < current.start){//能剥离开
                result.add(last);
                last = current;
            }else{//剥离不开
                int s = last.start;
                int e = Math.max(last.end, current.end);
                last = new Interval(s, e);
            }
        }
        result.add(last);
        return result;


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
        //System.out.println(merge(intervals));
    }
}
