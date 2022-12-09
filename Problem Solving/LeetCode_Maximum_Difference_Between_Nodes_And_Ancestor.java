import java.util.*;
class LeetCode_Maximum_Difference_Between_Nodes_And_Ancestor{
    public static void main(String args[]){
        Tree t = new Tree();
        t.createTree(Arrays.asList(8,3,10,1,6,null,14,null,null,4,7,13));

        System.out.println(maxAncestorDiff(t.root));
    }
    public static int maxAncestorDiff(TreeNode root) {
        if(root==null)return 0;

        return dfs(root,root.val,root.val);
    }
    public static int dfs(TreeNode root,int currMax,int currMin){
        if(root==null)return currMax-currMin;

        currMax = Math.max(currMax,root.val);
        currMin = Math.min(currMin,root.val);

        int left = dfs(root.left,currMax,currMin);
        int right = dfs(root.right,currMax,currMin);
        
        return Math.max(left,right);
    }
}