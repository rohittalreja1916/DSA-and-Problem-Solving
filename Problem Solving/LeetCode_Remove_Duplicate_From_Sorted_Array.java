import java.util.Arrays;

class LeetCode_Remove_Duplicate_From_Sorted_Array {
    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }    
    public static int removeDuplicates(int[] nums) {
        
        int slow=0,fast=1;
        while(fast<nums.length){
            if(nums[slow]!=nums[fast]){
                slow++;
                nums[slow]=nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
