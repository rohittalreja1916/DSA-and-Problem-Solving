

class LeetCode_Number_of_Unequal_Triplets_in_Array {
    public static void main(String[] args) {
        int nums[] = {4,4,2,4,3};
        System.out.println(unequalTriplets(nums));

    }
    public static int unequalTriplets(int[] nums) {
        int count=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]!=nums[j]){
                    for(int k=j+1;k<n;k++){
                        if((nums[k]!=nums[i])&&(nums[k]!=nums[j]))count++;
                    }
                }
            }
        }   
        return count;
    }
}
