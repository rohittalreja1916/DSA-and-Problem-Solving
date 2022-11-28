class LeetCode_Arithmetic_Slices {
    public static void main(String[] args) {
        int nums[] = {2,5,9,12,15,18,22,26,30};
        System.out.println(numberOfArithmeticSlices(nums));
    }   
    public static int numberOfArithmeticSlices(int[] nums) {
        int dp[] = new int[nums.length];
        int ans=0;
        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                dp[i]=dp[i-1]+1;
                ans+=dp[i];
            }
        }
        return ans;
    } 
}
