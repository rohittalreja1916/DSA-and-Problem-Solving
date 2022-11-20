import java.util.*;
class LeetCode_Online_Stock_Span {
    public static void main(String[] args) {
        StockSpanner s = new StockSpanner();
        int prices[] = {100,80,60,70,60,75,85};
        for(int i=0;i<prices.length;i++){
            System.out.print(s.next(prices[i])+" ");
        }
    }
}
class StockSpanner {
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<int[]>();
    }
    
    public int next(int price) {
        int ans=1;
        while(!stack.isEmpty() && stack.peek()[0]<=price){
            ans+=stack.pop()[1];
        }
        stack.push(new int[]{price,ans});
        return ans;
    }
}