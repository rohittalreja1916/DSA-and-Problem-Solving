import java.util.*;
class LeetCode_Reverse_Words_In_A_String {
    public static void main(String[] args) {
        String line ="the sky is blue";
        System.out.println(reverseWords(line));
    }   
    public static String reverseWords(String s){

        String ans = new String();
        for(int i=s.length()-1;i>=0;i--){
            StringBuilder word = new StringBuilder();
            while(i>=0 && s.charAt(i)!=' '){
                word.append(s.charAt(i));
                i--;
            }
            if(word.length()!=0)ans+=(word.reverse()+" ");
        }
        return ans.trim();       
    } 
    //Using Stack
    public static String reverseWords1(String s){
        Stack<String> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ')continue;
            String word="";
            while(i<s.length() && s.charAt(i)!=' '){
                word+=s.charAt(i);
                i++;
            }
            stk.push(word);
        }
        String ans = "";
        while(!stk.isEmpty()){
            ans+=stk.pop();
            if(!stk.isEmpty())ans+=" ";
        }
        return ans;
    }
}
