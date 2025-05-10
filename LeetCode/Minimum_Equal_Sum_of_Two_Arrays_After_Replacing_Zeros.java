/*
 * Question : https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/
 * Difficulty : Medium
 * Topics : Array Greedy
*/

public class Minimum_Equal_Sum_of_Two_Arrays_After_Replacing_Zeros {
     public static void main(String[] args) {
        int nums1[] = {0,7,28,17,18};
        int nums2[] = {1,2,6,26,1,0,27,3,0,30};

        long ans = minSum(nums1, nums2);
        System.out.println(ans);
    }

    public static long minSum(int[] nums1, int[] nums2) {
        ArrayStats stats1 = calculateArrayStats(nums1);
        ArrayStats stats2 = calculateArrayStats(nums2);

        if (stats1.zeros == 0 && stats2.zeros == 0)
            return stats1.sum == stats2.sum ? stats1.sum : -1 ;

        long minPossible1 = stats1.sum + stats1.zeros;
        long minPossible2 = stats2.sum + stats2.zeros;

        if ((stats1.zeros == 0 && minPossible2 > stats1.sum) || (stats2.zeros == 0 && minPossible1 > stats2.sum)) return -1 ;

        return Math.max(minPossible1, minPossible2);
    }

    static class ArrayStats {
        long sum;
        long zeros;

        ArrayStats(long sum, long zeros) {
            this.sum = sum;
            this.zeros = zeros;
        }
    }

    private static ArrayStats calculateArrayStats(int[] nums) {
        long sum = 0;
        long zeros = 0;

        for (int num : nums) {
            if (num == 0) zeros++;
            sum += num;
        }

        return new ArrayStats(sum, zeros);
    }
}
