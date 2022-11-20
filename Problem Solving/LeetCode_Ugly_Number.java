class LeetCode_Ugly_Number {
    public static void main(String[] args) {
        int n = 75;
        // System.out.println(recursiveIsUgly(n));
        System.out.println(isUgly(n));
    }   
    public static boolean isUgly(int n) {
        if(n<=0)return false;
        for(int factor:new int[]{2,3,5}){
            n=keepDividingWhenDivisible(n,factor);
        }
        if(n==1)return true;
        return false;
    } 
    public static int keepDividingWhenDivisible(int dividend, int divisor) {
        while(dividend%divisor==0)dividend/=divisor;

        return dividend;
    }

    //recursive implementation
    public static boolean recursiveIsUgly(int n){
        if(n<=0)return false;
        if(n==1)return  true;
        if(n%2==0)return recursiveIsUgly(n/2);
        if(n%3==0)return recursiveIsUgly(n/3);
        if(n%5==0)return recursiveIsUgly(n/5);

        return false;
    }
}
