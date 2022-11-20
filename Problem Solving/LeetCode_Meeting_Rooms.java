
import java.util.*;

class LeetCode_Meeting_Rooms{
    public static void main(String[] args) {
        
        int intervals[][] = {
            {0,30},
            {5,10},
            {15,20}
        };
        System.out.println(minMeetingRooms(intervals));
    }
    public static boolean minMeetingRooms(int intervals[][]){

        List<Interval> events = new ArrayList<>();
        for(int i[]:intervals){
            events.add(new Interval(i[0],true));
            events.add(new Interval(i[1],false));
        }
        Collections.sort(events,(a,b)->a.value-b.value);

        int min_rooms = 0;
        int rooms =0;
        for(Interval i:events){
            if(i.startOrEnd)rooms+=1;
            else rooms-=1;
            min_rooms=Math.max(min_rooms, rooms);
        }
        return min_rooms<2;
    }
    static class Interval{
        int value;
        boolean startOrEnd;
        Interval(int value,boolean startOrEnd){
            this.value=value;
            this.startOrEnd=startOrEnd;
        }
    }
}