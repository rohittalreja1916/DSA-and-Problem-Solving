
import java.util.*;
class LeetCode_Merge_Intervals {
    public static void main(String[] args) {
        // int intervals[][] = {
        //     {1,3},
        //     {2,6},
        //     {8,10},
        //     {15,18}
        // };
        int intervals[][] ={
            {1,4},
            {4,5}
        };
        int ans[][] = merge(intervals);
        for(int i[]:ans){
            System.out.println(Arrays.toString(i));
        }
    }
    //using Sweep Line
    public static int[][] merge(int[][] intervals) {
        List<Interval> interval= new ArrayList<>();
        for(int i[]:intervals){
            interval.add(new Interval(i[0],true));
            interval.add(new Interval(i[1],false));
        }
        Collections.sort(interval);
        int sameInterval=0;
        int previousStartPoint=interval.get(0).value;
        List<int[]> ans = new ArrayList<>();
        for(Interval i: interval){
            if(sameInterval==0)previousStartPoint=i.value;
            if(i.startOrEnd)sameInterval++;
            else sameInterval--;

            if(sameInterval==0)ans.add(new int[]{previousStartPoint,i.value});
        }
        return ans.toArray(new int[ans.size()][]);
    }
    static class Interval implements Comparable<Interval>{
        int value;
        boolean startOrEnd; //start true and end false
        Interval(int value,boolean startOrEnd){
            this.value=value;
            this.startOrEnd=startOrEnd;
        }
        public int compareTo(Interval other){
            if(this.value==other.value){
                if(this.startOrEnd)return -1;
                else return 1;
            }else if(this.value<other.value)return -1;
            else return 1;
        }
    }
}
