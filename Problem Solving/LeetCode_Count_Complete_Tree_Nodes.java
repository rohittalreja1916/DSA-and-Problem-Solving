import java.util.Arrays;
// import Templates.Tree.*;
//TreeNode and its implementation is given in Template Tree folder
class LeetCode_Count_Complete_Tree_Nodes{
    static int count=0;
    public static void main(String[] args) {
        Tree t = new Tree();
        
        t.createTree(Arrays.asList(1,2,3,4,5,6));
        System.out.println(countNodes(t.root));
    }
    public static int countNodes(TreeNode root) {
        dfs(root);
        return count;
    }
    public static void dfs(TreeNode root){
        if(root==null)return;
        count++;
        dfs(root.left);
        dfs(root.right);
    }
}