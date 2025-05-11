/*
 * Question : https://leetcode.com/problems/three-consecutive-odds
 * Difficulty : Easy
 * Topics : Array
*/

public class ThreeConsecutiveOdds {
    public static void main(String[] args) {
        int arr[] = {1,2,34,3,4,5,7,23,12};

        boolean ans = threeConsecutiveOdds(arr);
        System.out.println(ans);
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        for(int i = 1; i < arr.length -1; i++){
            if(arr[i]%2!=0 && arr[i-1]%2!=0 && arr[i+1]%2!=0) return true;
        }

        return false;
    }
}
