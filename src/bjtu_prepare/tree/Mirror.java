package bjtu_prepare.tree;

import java.util.Stack;


/*
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 *
 * 二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	    镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
    	
 */
public class Mirror {

	public void mirror(TreeNode root) {
		if(root == null){
			return;
		}
		TreeNode temp = null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(root != null || !stack.isEmpty()){
			while(root != null){
				temp =root.left;
				root.left = root.right;
				root.right = temp;
				stack.push(root);
				root = root.left;
			}
			if(!stack.isEmpty()){
				root = stack.pop();
				root = root.right;
			}

		}
	}
}
