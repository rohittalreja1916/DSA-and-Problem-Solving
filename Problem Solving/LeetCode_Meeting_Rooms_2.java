import java.util.*;

class LeetCode_Meeting_Rooms_2{
    public static void main(String[] args) {
        
        int intervals[][] = {
            {7,10},
            {2,14}
        };
        System.out.println(minMeetingRooms(intervals));
    }
    public static int minMeetingRooms(int intervals[][]){

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
        return min_rooms;
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