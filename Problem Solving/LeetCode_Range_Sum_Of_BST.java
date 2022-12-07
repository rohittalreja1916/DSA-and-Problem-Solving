import java.util.Arrays;

public class LeetCode_Range_Sum_Of_BST {
    public static void main(String[] args) {
        Tree t = new Tree();
        t.createTree(Arrays.asList(10,5,15,3,7,null,18));
        int low = 7,high = 15;
        
        System.out.println(rangeSumBST(t.root, low, high));
    }
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null)return 0;
        if(root.val<low)return rangeSumBST(root.right, low, high);
        if(root.val>high)return rangeSumBST(root.left, low, high);
        
        return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
    }
}
