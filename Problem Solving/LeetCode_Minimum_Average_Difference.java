class LeetCode_Minimum_Average_Difference{
    public static void main(String args[]){
        int nums[] = {0,1,0,1,0,1};
        System.out.println(minimumAverageDifference1(nums));
    }

    //Prefix Sum
    public static int minimumAverageDifference(int[] nums) {
        
        int n = nums.length;
        long prefixSum[] = new long[n];
        int ans=-1;
        int min_value=Integer.MAX_VALUE;

        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++)prefixSum[i]=nums[i]+prefixSum[i-1];

        for(int i=0;i<n;i++){
            long leftPartAvg = prefixSum[i]/(i+1);
            long rightPartAvg = (n-1==i)?0:((prefixSum[n-1]-prefixSum[i])/(n-i-1));
            int diff = (int)Math.abs(leftPartAvg - rightPartAvg);
            if(diff<min_value){ 
                min_value = diff;
                ans=i;
            }
        }
        return ans;
    }

    //Prefix Sum Optimized
    public static int minimumAverageDifference1(int[] nums){
        int n = nums.length;
        long totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        long currentSum=0;
        int min_avg_value = Integer.MAX_VALUE; 
        int ans=0;
        for(int i=0;i<n;i++){
            currentSum+=nums[i];
            long leftPartAvg = currentSum/(i+1);
            long rightPartAvg = totalSum -currentSum;
            if(n-i-1!=0)rightPartAvg /= (n-i-1);
            int currentDifference = (int)Math.abs(leftPartAvg - rightPartAvg);
            if(currentDifference<min_avg_value){ 
                min_avg_value = currentDifference;
                ans=i;
            }
        }
        return ans;
    }
}