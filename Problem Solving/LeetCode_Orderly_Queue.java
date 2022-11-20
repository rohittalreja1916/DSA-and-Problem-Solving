import java.util.*;
class LeetCode_Orderly_Queue {
    public static void main(String[] args) {
        String s = "cba";
        int k = 1;
        System.out.println(orderlyQueue(s,k));
    }   
    public static String orderlyQueue(String s, int k) {
        //If k==1 then only we have to check for each string by replacing the char and return the lexicographically smallest string from all of them
        if(k==1){
            String ans = s;
            for (int i = 0; i < s.length(); ++i) {
                String temp = s.substring(i) + s.substring(0, i);
                if (temp.compareTo(ans) < 0) {
                    ans = temp;
                }
            }
            return ans;
        }else{
        // else no need to check 
        //always lexicographically string will be the smallest
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            return new String(arr);
        }
    } 
}
