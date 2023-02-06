import java.util.*;
/*
 * Question: https://leetcode.com/problems/shuffle-the-array/
 * Difficulty : Easy
 * Topics : Array
 */

public class Shuffle_The_Array{
    public static void main(String args[]){
        int nums[] = {2,5,1,3,4,7};
        int n = 3;
        int ans[] = shuffle(nums,n);
        System.out.println(Arrays.toString(ans));
    }

    /*
     * Approach : Iterate
     * TC : O(n)
     * SC : O(1) 
     */
    public static int[] shuffle(int[] nums, int n) {
        int ans[] = new int[2*n]; 
        for(int i=0;i<n;i++){
            ans[2*i]=nums[i];
            ans[2*i + 1]=nums[n+i];
        }
        return ans;
    }
}