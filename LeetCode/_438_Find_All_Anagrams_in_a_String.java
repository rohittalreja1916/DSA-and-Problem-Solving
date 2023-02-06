import java.util.*;
/*
 * Question : https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * Difficulty : Medium
 * Topics : Hash Table, String, Sliding Window
*/

public class _438_Find_All_Anagrams_in_a_String {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";

        List<Integer> ans = findAnagrams(s,p);
        System.out.println(ans);
    }    

    /*
     * Approach -1 : Sliding Window Approach 
     * TC : O(m+n) where m is length of string s and n is length of string p
     * SC : O(1) as we are using two array of size 26 only
     */
    public static List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        char pfreq[] = new char[26];
        for(char p1:p.toCharArray())pfreq[p1-'a']++;

        char sfreq[] = new char[26];
        int cnt=0;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            char ch = s.charAt(i);
            if(pfreq[ch-'a']==0){
                sfreq = new char[26];
                cnt=0;
            }
            else if(pfreq[ch-'a']!=sfreq[ch-'a']){
                cnt++;
                sfreq[ch-'a']++;
            }else if(pfreq[ch-'a']==sfreq[ch-'a']){
                int j = i-cnt;
                char ch1 = s.charAt(j);
                while(ch1!=ch){
                    sfreq[ch1-'a']--;
                    cnt--;
                    j++;
                    ch1=s.charAt(j);
                }
            }
            if(cnt==n){
                ans.add(i-n+1);
                cnt--;
                sfreq[s.charAt(i-n+1)-'a']--;
            }
        }
        return ans;
    }
    /*
     * Approach - 2 String and Array
     * TC: O(m*n(logn))  as we are sorting the part of string s of length n and 
     * it is for m-n times.
     * SC: O(m+n)
     */

    public static List<Integer> findAnagrams_1(String s, String p){
        int m = s.length();
        int n = p.length();
        char pi[] =p.toCharArray();
        Arrays.sort(pi);
        String pval = String.valueOf(pi);
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<=m-n;i++){
            char part[] = s.substring(i,i+n).toCharArray();
            Arrays.sort(part);
            if(String.valueOf(part).equals(pval))ans.add(i);      
        }
        return ans;
    }
}
