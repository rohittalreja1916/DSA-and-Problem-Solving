import java.util.*;
class LeetCode_Remove_All_Adjacent_Duplicates {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }   
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(!stack.isEmpty() && c==stack.peek())stack.pop();
            else stack.push(c);
        }
        StringBuilder res = new StringBuilder();
        for(char c:stack){
            res.append(c);
        }
        return res.toString();
    } 
}
