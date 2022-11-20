// import java.util.*;
class LeetCode_Make_The_String_Good {
    public static void main(String[] args) {
        String s ="leEeetcode";
        System.out.println(makeGood(s));
    }
    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<sb.length()-1;i++){
            if(Math.abs(sb.charAt(i)-sb.charAt(i+1))==32){
                sb.delete(i, i+2);
                i-=(i==0)?1:2;
            }
        }
        return sb.toString();
        
        //Using Stack
        // Stack<Character> stk = new Stack<>();
        // for(char currchar:s.toCharArray()){
        //     if(!stk.isEmpty() && Math.abs(currchar-stk.peek())==32){
        //         stk.pop();
        //     }else stk.push(currchar);
        // }
        // StringBuilder ans = new StringBuilder();
        // for(char c:stk)ans.append(c);
        
        // return ans.toString();
    }
}
