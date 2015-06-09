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
        //��intervals��start��������������������д��Comparator��compare������??��
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        Interval last = intervals.get(0);
        Iterator<Interval> iter = intervals.iterator();
        while(iter.hasNext()){//����ֻ���ز���ֵ��ǰ��
            Interval current = iter.next();//����ǰ��
            if(current.start > last.end){//���԰���current��last
                ans.add(last);
                last = current;
            }else{//���ܰ���
                last = new Interval(last.start, Math.max(current.end, last.end));
            }
        }
        ans.add(last);//����ĩβ������
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
