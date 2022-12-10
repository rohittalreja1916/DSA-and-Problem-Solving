import java.util.*;
class LeetCode_Maximum_Product_Of_Splitted_Binary_Tree{
    public static void main(String args[]){
        Tree t = new Tree();
        t.createTree(Arrays.asList( 1,null,2,null,null,3,4,null,null,null,null,null,null,5,6));

        System.out.println(maxProduct(t.root));
    }
    static long totalSum=0;
    static long maxProduct=0;
    public static int maxProduct(TreeNode root) {
        dfs(root);

        findMax(root);
        return (int)((maxProduct) % (Math.pow(10,9)+7));
    }
    public static void dfs(TreeNode root){
        if(root==null)return;
        totalSum+= (long)root.val; 
        dfs(root.left);
        dfs(root.right);
    }
    public static long findMax(TreeNode root){
        if(root==null)return 0;

        long l = findMax(root.left);
        long r = findMax(root.right);
        maxProduct = Math.max(maxProduct,(l+r+root.val)*(totalSum-l-r-root.val));

        return l+r+root.val;
    }
}