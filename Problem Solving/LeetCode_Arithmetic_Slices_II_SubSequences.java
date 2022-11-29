import java.util.*;
class LeetCode_Arithmetic_Slices_II_SubSequences {
    public static void main(String[] args) {
        int nums[]={4,2,3,5,2,6,7};
        System.out.println(numberOfArithmeticSlices(nums));
    }   
    public static int numberOfArithmeticSlices(int[] nums) {
        int ans =0;

        List<Map<Integer,Integer>> maps = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            Map<Integer,Integer> currMap=new HashMap<>();
            maps.add(currMap);
            for(int j=0;j<i;j++){
                long diff = (long)nums[i]-(long)nums[j];

                if(diff <= Integer.MIN_VALUE || diff >= Integer.MAX_VALUE )continue;
                int mapEndingOnI = maps.get(i).getOrDefault((int)diff,0);
                int mapEndingOnJ = maps.get(j).getOrDefault((int)diff,0);

                ans+=mapEndingOnJ;
                currMap.put((int)diff,mapEndingOnI + mapEndingOnJ + 1);
            }
        }
        return ans;
    }
}
//Map[] maps = list.toArray(new HashMap[list.size()]);