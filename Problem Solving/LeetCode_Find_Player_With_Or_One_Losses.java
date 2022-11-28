import java.util.*;
class LeetCode_Find_Player_With_Or_One_Losses {
    public static void main(String[] args) {
        List<List<Integer>> ans = findWinners(new int[][]{
            {1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}
        });
        for(List<Integer> i:ans){
            System.out.println(i);
        }
    }
    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer,Integer> winner = new HashMap<>();
        Map<Integer,Integer> looser = new HashMap<>();
        for(int i[]:matches){
            winner.put(i[0],winner.getOrDefault(i[0],0)+1);
            looser.put(i[1],looser.getOrDefault(i[1],0)+1);
        }
        List<Integer> zeroLost = new ArrayList<>();
        List<Integer> oneLost = new ArrayList<>();
        for(int i:winner.keySet()){
            if(!looser.containsKey(i))zeroLost.add(i);
        }
        for(int i:looser.keySet()){
            if(looser.get(i)==1)oneLost.add(i);
        }
        Collections.sort(zeroLost);
        Collections.sort(oneLost);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(zeroLost);
        ans.add(oneLost);
        return ans;
    }
}
