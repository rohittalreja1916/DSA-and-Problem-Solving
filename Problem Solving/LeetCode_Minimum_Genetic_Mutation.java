import java.util.*;
class LeetCode_Minimum_Genetic_Mutation{
    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String bank[] = {"AACCGGTA"};
        System.out.println(minMutation(start,end,bank));
    }
    public static int minMutation(String start, String end, String[] bank) {
        
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.add(start);
        seen.add(start);
        int steps = 0;

        while(!queue.isEmpty()){
            int nodeInQueue = queue.size();
            for(int i=0;i<nodeInQueue;i++){
                String  node = queue.remove(); 
                if(node.equals(end))return steps;

                for(char c:new char[]{'A','C','G','T'}){
                    for(int j=0;j<node.length();j++){
                        String neighbour = node.substring(0,j)+c+node.substring(j+1);

                        if(!seen.contains(neighbour) && Arrays.asList(bank).contains(neighbour)){
                            queue.add(neighbour);
                            seen.add(neighbour);
                        }
                    }
                }                
            }
            steps++;
        }
        return -1;
    }
}