import java.util.*;
class LeetCode_Leaf_Similar_Trees{
    public static void main(String args[]){
        Tree t1 = new Tree();
        t1.createTree(Arrays.asList(3,5,1,6,2,9,8,null,null,7,4));

        Tree t2 = new Tree();
        t2.createTree(Arrays.asList(3,5,1,6,7,4,2,null,null,null,null,null,null,9,8));

        System.out.println(leafSimilar(t1.root, t2.root));

    }
    static List<Integer> lst1 = new ArrayList<>();
    static List<Integer> lst2 = new ArrayList<>();
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        dfs(root1,lst1);
        dfs(root2,lst2);

        return lst1.size()==lst2.size() && lst1.equals(lst2);
    }
    public static void dfs(TreeNode root,List<Integer> lst){
        if(root==null)return;
        if(root.left==null && root.right==null){
            lst.add(root.val);
            return ;
        }
        dfs(root.left,lst);
        dfs(root.right,lst);
    }
}