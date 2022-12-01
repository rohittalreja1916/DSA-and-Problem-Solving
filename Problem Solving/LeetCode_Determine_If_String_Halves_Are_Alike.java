class LeetCode_Determine_If_String_Halves_Are_Alike{
    public static void main(String args[]){
        String s = "textbook";
        System.out.println(halvesAreAlike(s));
    }
    public static boolean halvesAreAlike(String s) {
        int cnt=0,cnt1=0;
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                if(i>=s.length()/2 )cnt1++;
                else cnt++;
            }
        }
        return cnt1==cnt;
    }
    public static boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
}