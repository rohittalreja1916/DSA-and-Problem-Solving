// https://leetcode.com/problems/maximum-69-number/solutions/2786782/java-one-line-solution-4ms/

class LeetCode_Maximum_69_Number {
    public static void main(String[] args) {
        int num = 9669;
        System.out.println(maximum69Number(num));
    }    
    public static int maximum69Number (int num) {
        //Convert number to string and then if 6 present then replace 
        //first character of 6 with 9 else don't replace and then again 
        //convert string to int.
        return Integer.parseInt(
                Integer.toString(num)
                .replaceFirst("6", "9")
        );
    }
}
