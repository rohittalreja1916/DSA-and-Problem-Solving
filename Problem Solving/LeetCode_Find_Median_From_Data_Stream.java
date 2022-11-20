import java.util.*;

class LeetCode_Find_Median_From_Data_Stream {
    public static void main(String[] args) {
        int input[] = {
            1,0,2,0,7,0
        };
        MedianFinder m = new MedianFinder();
        for(int i:input){
            if(i==0)System.out.print(String.format("%.5f",m.findMedian())+" ");
            else m.addNum(i);
        }
    }    
}   

class MedianFinder {
    Queue<Integer> max;
    Queue<Integer> min;
    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }
    public void addNum(int num) {
        min.offer(num);
        max.offer(min.poll());
        if(min.size() < max.size()){
            min.offer(max.poll());
        }
    }
    
    public double findMedian() {
        if(min.size() == max.size()){
            return (min.peek() + max.peek()) / 2.0;
          } else {
            return min.peek();
          } 
    }
}

//Using List Basic Approach
class MedianFinder1 {
    List<Integer> list;
    public MedianFinder1() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        if(list.size()==0)list.add(num);
        else{
            int i=0;
            while(list.get(i)<=num && i<list.size()-1)i++;
            if(list.get(i)<=num)list.add(i+1,num);
            else list.add(i,num);
        }   
    }
    
    public double findMedian() {
        int n = list.size();
        if(n==0)return 0;
        else if(n%2==1)return list.get(n/2);
        else return (double)(list.get(n/2)+list.get(n/2-1))/2;
    }
}