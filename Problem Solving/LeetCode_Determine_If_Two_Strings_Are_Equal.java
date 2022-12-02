import java.util.*;

class LeetCode_Determine_If_Two_Strings_Are_Equal{
    public static void main(String args[]){
        String word1 ="abc",word2="bca";
        System.out.println(closeStrings(word1, word2));
    }

    //Using Arrays
    public static boolean closeStrings(String word1, String word2) {

        int arr1[] = new int[26];
        int arr2[] = new int[26];
        for(char c:word1.toCharArray())arr1[c-'a']++;
        for(char c:word2.toCharArray())arr2[c-'a']++;

        for(int i=0;i<26;i++){
            if(arr1[i]==arr2[i])continue;   //if both are 0 then continue
            if(arr1[i]==0 || arr2[i]==0)return false;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i])return false;
        }
        return true;
    }

    //Using Map and List 
    public static boolean closeStrings1(String word1, String word2) {
        
        if(word1.length()!=word2.length())return false;
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for(int i=0;i<word1.length();i++){
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0)+1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0)+1);
        }

        if(map1.size()!=map2.size())return false;

        List<Integer> lst1 = new ArrayList<>();
        List<Integer> lst2 = new ArrayList<>();
        List<Character> lst3 = new ArrayList<>();
        List<Character> lst4 = new ArrayList<>();

        for(var v:map1.entrySet()){
            lst1.add(v.getValue());
            lst3.add(v.getKey());
        }
        for(var v:map2.entrySet()){
            lst2.add(v.getValue());
            lst4.add(v.getKey());
        }
        Collections.sort(lst1);
        Collections.sort(lst2);
        Collections.sort(lst3);
        Collections.sort(lst4);

        if(lst1.equals(lst2) && lst3.equals(lst4))return true;

        return false;
    }
}