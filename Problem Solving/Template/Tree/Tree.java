import java.util.*;
// import Tree.TreeNode;

public class Tree {
    public TreeNode root=null;
    public Tree(){
        root = new TreeNode();
    }
    //methods
    public void createTree(List<Integer> input){
        root = insertLevelOrder(input, 0);
    }
    public void printInOrder(){
		printInOrder(this.root);
	}
	public void printPreOrder(){
		printPreOrder(this.root);
	}
	public void printPostOrder(){
		printPostOrder(this.root);
	}
	public void printLevelOrder(){
		printLevelOrder(this.root);
	}
    public int findHeight(){
        return findHeight(this.root);
    }
    public List<List<Integer>> getAllPaths(){
        getPaths(this.root);
        return paths;
    }

    //implementations
    private TreeNode insertLevelOrder(List<Integer> input, int i){
        TreeNode root = null;

        if (i < input.size()) {
            if(input.get(i)==null)return root;
            root = new TreeNode(input.get(i));
            root.left = insertLevelOrder(input, 2 * i + 1);
            root.right = insertLevelOrder(input, 2 * i + 2);
        }
        return root;
    }

    private void printInOrder(TreeNode node){
		if(node==null)return;

		printInOrder(node.left);
		System.out.print(node.val+" ");
		printInOrder(node.right);
	} 

    private void printPreOrder(TreeNode node){
		if(node==null)return;

		System.out.print(node.val+" ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}

    private void printPostOrder(TreeNode node){
		if(node==null) return;

		printPostOrder(node.left);
		printPostOrder(node.right);
		System.out.print(node.val+" ");
	}

    private void printLevelOrder(TreeNode node){
		Queue<TreeNode> que=new LinkedList<TreeNode>();
		que.add(root);
		while(!que.isEmpty()){
			TreeNode temp = que.poll();
			System.out.print(temp.val+" ");

			if(temp.left!=null){
				que.add(temp.left);
			}
			if(temp.right!=null){
				que.add(temp.right);
			}
		}
	}

    private int findHeight(TreeNode node){
		if(node == null)return -1;
		else{
			int ldepth=findHeight(node.left);
			int rdepth=findHeight(node.right);

			if(ldepth>rdepth)return ldepth+1;
			else return rdepth+1;
		}
	}

    List<List<Integer>> paths = new ArrayList<>();
    private void getPaths(TreeNode node){
		int height = findHeight(root);
		int path[] = new int[height+1];
		getAllRootToLeefPath(node,path,0);
	}
    private void getAllRootToLeefPath(TreeNode node,int path[],int pathLength){
		if(node==null)return;

		path[pathLength]=node.val;
        pathLength++;
        
		if(node.left==null && node.right==null){
            List<Integer> part = new ArrayList<>();
            for(int i=0;i<pathLength;i++)part.add(path[i]);
			paths.add(part);
		}else{
			getAllRootToLeefPath(node.left,path,pathLength);
			getAllRootToLeefPath(node.right,path,pathLength);
		}
	}

}