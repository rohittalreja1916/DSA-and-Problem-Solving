import java.util.*;
class LeetCode_Insert_Delete_GetRandom_O_1 {
    public static void main(String[] args) {
        char tasks[] = {'i','r','i','R','r','i','R'};
        int values[] = {1,2,2,0,1,2,0};
        
        RandomizedSet r = new RandomizedSet();
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