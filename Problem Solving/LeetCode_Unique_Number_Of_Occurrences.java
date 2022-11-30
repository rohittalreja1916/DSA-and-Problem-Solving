import java.util.*;
class LeetCode_Unique_Number_Of_Occurences{
    public static void main(String[] args) {
        int arr[] = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));
    }
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> unique = new HashSet<>();

        for(int i:arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(int i:map.values()){
            if(unique.contains(i))return false;
            else unique.add(i);
        }
        return true;
    }
}