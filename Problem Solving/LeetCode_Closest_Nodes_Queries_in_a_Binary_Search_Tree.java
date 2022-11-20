import java.util.*;

public class LeetCode_Closest_Nodes_Queries_in_a_Binary_Search_Tree {
    public static void main(String[] args) {
        
    }
    List<Integer> treeValues;
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        treeValues = new ArrayList<>();
        
        addInList(root);
        Collections.sort(treeValues);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        System.out.println(treeValues);
        for(int i:queries){
            List<Integer> part = new ArrayList<>();
            part.add(onePreviousOrNext(treeValues,i,true));
            part.add(onePreviousOrNext(treeValues,i,false));
            
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
    public int onePreviousOrNext(List<Integer> treeValues, int findValue,boolean previousOrNext){
        if(!previousOrNext && findValue>treeValues.get(treeValues.size()-1))return -1;
        if(previousOrNext && findValue>treeValues.get(treeValues.size()-1))return treeValues.get(treeValues.size()-1);
        int left=0,right = treeValues.size();
        int mid = -1;
        while(left<=right){
            mid = left + (right-left)/2;
            if(treeValues.get(mid)==findValue)return treeValues.get(mid);
            else if(treeValues.get(mid)>findValue)right=mid-1;
            else left=mid+1;
        }
        return (previousOrNext)?((right!=-1)?treeValues.get(right):right):((left!=-1)?treeValues.get(left):left);
    }
}
