import java.util.*;
public class LeetCode_Insert_Delete_GetRandom_O_1_Duplicates_Allowed {
    public static void main(String[] args) {
        char tasks[] = {'i','i','i','R','r','R'};
        int values[] = {1,1,2,0,1,0};
        
        RandomizedCollection r = new RandomizedCollection();
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

class RandomizedCollection {

    List<Integer> lst;
    Map<Integer,Set<Integer>> map;
    Random rnd;
    public RandomizedCollection() {
        lst = new ArrayList<>();
        map = new HashMap<>();
        rnd = new Random();
    }
    
    public boolean insert(int val) {

        if(!map.containsKey(val))map.put(val, new LinkedHashSet<>());
        map.get(val).add(lst.size());
        lst.add(val);
        return map.get(val).size()==1;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val) || map.get(val).size()==0)return false;

        int remove_index = map.get(val).iterator().next();
        map.get(val).remove(remove_index);
        int lastValue = lst.get(lst.size()-1);
        lst.set(remove_index,lastValue);
        map.get(lastValue).add(remove_index);
        map.get(lastValue).remove(lst.size()-1);
        
        lst.remove(lst.size()-1);
        return true;
    }
    
    public int getRandom() {
        return lst.get(rnd.nextInt(lst.size()));
    }
}
