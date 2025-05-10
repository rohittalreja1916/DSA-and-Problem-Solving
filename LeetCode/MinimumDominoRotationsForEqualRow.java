/*
 * Question : https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 * Difficulty : Medium
 * Topics : Array Greedy
*/

import java.util.*;

public class MinimumDominoRotationsForEqualRow {
    public static void main(String[] args) {
        int tops[] = {1,2,1,1,1,2,2,2};
        int bottoms[] = {2,1,2,2,2,2,2,2};

        long ans = minDominoRotations(tops, bottoms);
        System.out.println(ans);
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {

        int result = isValid(tops, bottoms, tops[0]);
        if(result != -1) return result;
        return isValid(tops, bottoms, bottoms[0]);
    }

    private static int isValid(int[] tops, int[] bottoms, int target) {
        int rotateTop = 0, rotateBottom = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) return -1;
            else if (tops[i] != target) rotateTop++;
            else if (bottoms[i] != target) rotateBottom++;

        }
        return Math.min(rotateTop, rotateBottom);
    }

    // Approach 2 (Worst complexity)
    public static int minDominoRotationshashMap(int[] tops, int[] bottoms) {
        Map<Integer, Integer> countTop = new HashMap<>();
        Map<Integer, Integer> countBottom = new HashMap<>();
        Map<Integer, Integer> countSame = new HashMap<>();

        int n = tops.length;

        for (int i = 0; i < n; i++) {
            countTop.put(tops[i], countTop.getOrDefault(tops[i], 0) + 1);
            countBottom.put(bottoms[i], countBottom.getOrDefault(bottoms[i], 0) + 1);
            if (tops[i] == bottoms[i]) {
                countSame.put(tops[i], countSame.getOrDefault(tops[i], 0) + 1);
            }
        }

        int minRotations = Integer.MAX_VALUE;

        for (int i = 1; i <= 6; i++) {
            int top = countTop.getOrDefault(i, 0);
            int bottom = countBottom.getOrDefault(i, 0);
            int same = countSame.getOrDefault(i, 0);

            if (top + bottom - same >= n) {
                minRotations = Math.min(minRotations, Math.min(n - top, n - bottom));
                break;
            }
        }

        return minRotations == Integer.MAX_VALUE ? -1 : minRotations;
    }
}
