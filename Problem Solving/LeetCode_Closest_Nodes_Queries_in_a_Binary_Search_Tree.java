import java.util.*;

public class LeetCode_Closest_Nodes_Queries_in_a_Binary_Search_Tree {
    public static void main(String[] args) {
        Tree root = new Tree();
        List<Integer> input = Arrays.asList(6,2,13,1,4,9,15,null,null,null,null,14);
        root.createTree(input);
        List<Integer> queries = Arrays.asList(2,5,16);

        LeetCode_Closest_Nodes_Queries_in_a_Binary_Search_Tree obj = new LeetCode_Closest_Nodes_Queries_in_a_Binary_Search_Tree();
        List<List<Integer>> ans = obj.closestNodes(root.root, queries);

        for(var i:ans){
            System.out.println(i);
        }
    }

    //Correct Way of Approach
    //Tree Map
    TreeMap<Integer,Integer> treeMapValues = new TreeMap<>() ;
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {

        List<List<Integer>> ans = new ArrayList<>();
        addInMap(root);
        for(int i:queries){
            
            //if num is present add num else add lower value than num
            Integer low = treeMapValues.containsKey(i)?Integer.valueOf(i):treeMapValues.lowerKey(i);
            //if num is present add num else add higher value than num
            Integer high = treeMapValues.containsKey(i)?Integer.valueOf(i):treeMapValues.higherKey(i);
            //if low or high value also not present add -1 else add low or high
            ans.add(Arrays.asList(low==null?-1:low,high==null?-1:high));
        }
        return ans;
    }
    //The higherKey() method class is used to return the least key strictly greater than the given key, or null if there is no such key.
    //The lowerKey() method is used to return the greatest key strictly less than to given key
    public void addInMap(TreeNode root){
        if(root==null)return;

        treeMapValues.put(root.val, 0);

        addInMap(root.left);
        addInMap(root.right);
    }

    //Complex Approach and Simple Way of doing
    List<Integer> treeValues;
    public List<List<Integer>> closestNodes1(TreeNode root, List<Integer> queries) {
        treeValues = new ArrayList<>();
        
        addInList(root);
        Collections.sort(treeValues);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i:queries){
            List<Integer> part = new ArrayList<>();
            part.add(onePrevious(treeValues,i));
            part.add(oneNext(treeValues,i));
            
            ans.add(part);
        }
        return ans;
    }
    public void addInList(TreeNode root){
        if(root==null)return;
        
        treeValues.add(root.val);
        
        addInList(root.left);
        addInList(root.right);
    }
    public int onePrevious(List<Integer> treeValues, int findValue){
        if(findValue>treeValues.get(treeValues.size()-1))return treeValues.get(treeValues.size()-1);
        int left=0,right = treeValues.size()-1;
        int mid = -1;
        while(left<=right){
            mid = left + (right-left)/2;
            if(treeValues.get(mid)==findValue)return treeValues.get(mid);
            else if(treeValues.get(mid)>findValue)right=mid-1;
            else left=mid+1;
        }
        return ((right!=-1)?treeValues.get(right):right);
    }
    public int oneNext(List<Integer> treeValues, int findValue){
        if(findValue>treeValues.get(treeValues.size()-1))return -1;
        int left=0,right = treeValues.size()-1;
        int mid = -1;
        while(left<=right){
            mid = left + (right-left)/2;
            if(treeValues.get(mid)==findValue)return findValue;
            else if(treeValues.get(mid)>findValue)right=mid-1;
            else left=mid+1;
        }
        return treeValues.get(left);
    }
}