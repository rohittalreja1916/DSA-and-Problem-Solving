import java.util.*;
class LeetCode_Insert_Delete_GetRandom_O_1 {
    public static void main(String[] args) {
        char tasks[] = {'i','r','i','R','r','i','R'};
        int values[] = {1,2,2,0,1,2,0};
        
        RandomizedSet1 r = new RandomizedSet1();
        List<Object> ans = new ArrayList<>();
        ans.add(null);  //for object creation
        for(int i=0;i<values.length;i++){
            if(values[i]==0){
                ans.add(r.getRandom());
            }else{
                if(tasks[i]=='i')ans.add(r.insert(values[i]));
                else if(tasks[i]=='r')ans.add(r.remove(values[i]));
            }
        }
        System.out.println(ans);
    }
}
class RandomizedSet1 {
    List<Integer> lst;
    Set<Integer> set;
    Random rnd;
    public RandomizedSet1() {
        lst = new ArrayList<>();
        set = new HashSet<>();
        rnd = new Random();
    }
    
    public boolean insert(int val) {
        if(set.contains(val))return false;
        lst.add(val);
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!set.contains(val))return false;
        set.remove(val);
        lst.remove(Integer.valueOf(val));
        return true;
    }
    
    public int getRandom() {
        return lst.get(rnd.nextInt(lst.size()));
    }
}


class RandomizedSet {
    List<Integer> lst;
    Map<Integer,Integer> map;
    Random rnd;
    public RandomizedSet() {
        lst = new ArrayList<>();
        map = new HashMap<>();
        rnd = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))return false;
        lst.add(val);
        map.put(val,lst.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))return false;
        int lastValue = lst.get(lst.size()-1);
        int index = map.get(val);
        if(lst.size()!=1){
            lst.set(index, lastValue);
            map.put(lastValue, index);
        }
        map.remove(val);
        lst.remove(lst.size()-1);
        return true;
    }
    
    public int getRandom() {
        return lst.get(rnd.nextInt(lst.size()));
    }
}