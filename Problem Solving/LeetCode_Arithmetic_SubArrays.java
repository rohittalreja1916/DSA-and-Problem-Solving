import java.util.*;
class LeetCode_Arithmetic_SubArrays {
    public static void main(String[] args) {
        int nums[] = {4,6,5,9,3,7};
        int l[] ={0,0,2};
        int r[] ={2,3,5};
        System.out.println(checkArithmeticSubarrays(nums, l, r));
    }   
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int newNum[] =  new int[r[i]-l[i]+1];
            int k=0;
            for(int j=l[i];j<=r[i];j++){
                newNum[k++]=nums[j];
            }
            Arrays.sort(newNum);
            if(isArithemetic(newNum))ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
    public static boolean isArithemetic(int[] nums){
        if(nums.length<2)return false;
        int diff=nums[1]-nums[0];   
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]!=diff){
                return false;
            }
        }
        return true;
    }
}