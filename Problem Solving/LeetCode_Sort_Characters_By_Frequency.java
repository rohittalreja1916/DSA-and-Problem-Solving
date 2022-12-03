import java.util.*;
class LeetCode_Sort_Characters_By_Frequency{
    public static void main(String args[]){
        String s = "tree";
        System.out.println(frequencySort(s)); 
    }
    public static String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray())map.put(c,map.getOrDefault(c,0)+1);
        
        List<Element> lst = new ArrayList<>();
        for(var v: map.entrySet())lst.add(new Element(v.getKey(),v.getValue()));
        
        Collections.sort(lst,(a,b)->b.freq-a.freq);

        String ans ="";
        for(Element e:lst)ans+= Character.toString(e.c).repeat(e.freq);
        
        return ans;
    }
    static class Element{
        char c;
        int freq;
        Element(char c,int freq){
            this.c=c;
            this.freq=freq;
        }
    }
}