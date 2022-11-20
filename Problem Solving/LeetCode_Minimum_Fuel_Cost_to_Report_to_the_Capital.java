
import java.util.*;
public class LeetCode_Minimum_Fuel_Cost_to_Report_to_the_Capital {
    public static void main(String[] args) {
        int roads[][] = {
            {3,1},
            {3,2},
            {1,0},
            {0,4},
            {0,5},
            {4,6}
        };
        int seats = 2;
        System.out.println(minimumFuelCost(roads, seats));
    }
    static long ans =0;
    public static long minimumFuelCost(int[][] roads, int seats) {
        
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<=roads.length;i++) {
            List<Integer> part = new ArrayList<>();
            g.add(part);
        }
        for(int i[]:roads){
            List<Integer> part =g.get(i[0]);
            part.add(i[1]);
            g.set(i[0],part);
            part = g.get(i[1]);
            part.add(i[0]);
            g.set(i[1],part);
        }
        for(List<Integer> l:g){
            System.out.println(l);
        }
        dfs(0,-1,g,seats);
        return ans;
    }
    public static int dfs(int u, int p,List<List<Integer>> g,int seats){
        int w = 1;
        for(Integer v:g.get(u)){
            if(v==p)continue;
            w+=dfs(v, u, g,seats);
        }
        if(u==0)return w;
        ans+=(w+seats-1)/seats;
        return w;
    }
}
