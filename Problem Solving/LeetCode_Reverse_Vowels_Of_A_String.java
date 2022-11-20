public class LeetCode_Reverse_Vowels_Of_A_String {
    public static void main(String[] args) {
        String s ="leetcode";
        System.out.println(reverseVowels(s));
    }   
    //Approach 
    //Using Two Pointers to traverse from left and right towards to center.
    //Swap when both position contains vowels "aeiouAEIOU"

    public static String reverseVowels(String s) {
        //Using StringBuilder so that we can swap characters 
        StringBuilder str = new StringBuilder(s);
        
        int left=0,right=str.length()-1;
       
        // When both pointers meet, we know all the vowels are swapped.
        while(left<right){
            char ch = str.charAt(left);
            char ch1 = str.charAt(right);

            //If any one of them is not a vowel
            if(!isVowel(ch) || !isVowel(ch1)){
                //If left char is not a vowel then continue move to right side. 
                if(!isVowel(ch)){
                    left++;
                }
                //If right char is not a vowel then continue move to left side.
                if(!isVowel(ch1)){
                    right--;
                }
            }else if(isVowel(ch) && isVowel(ch1)){
                //Swap the chars of left and right and then continue move to right and left side.
                str.setCharAt(left,ch1);
                str.setCharAt(right,ch);
                left++;
                right--;
            }
        }
        //return after converting it to String.
        return str.toString();
    }

    //Check whether a char is a vowel or not.
    public static boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'
            || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U';
    }
}