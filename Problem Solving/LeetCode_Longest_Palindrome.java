import java.util.*;
class LeetCode_Longest_Palindrome{
    public static void main(String[] args) {
        String words[] = {"ab","ty","yt","lc","cl","ab"};

        System.out.println(longestPalindrome(words));
    }
    public static int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        
        Set<String> set = new HashSet<>();
        int ans=0;
        int flag=0;
        for(var v:map.entrySet()){
            String word = v.getKey();
            int cnt = v.getValue();
            String reverse = ""+word.charAt(1)+word.charAt(0);

            if(!set.contains(reverse)){

                if(word.equals(reverse)){
                    if(cnt%2==0)ans+=cnt*2;
                    else {
                        ans+=2*(cnt-1);
                        flag=1;
                    }
                    set.add(word);
                }
                else {
                    if(map.containsKey(reverse))ans+=Math.min(cnt,map.get(reverse))*4;
                    set.add(word);
                    set.add(reverse);
                }
            }
        }

        return ans+(flag*2);
    }
}