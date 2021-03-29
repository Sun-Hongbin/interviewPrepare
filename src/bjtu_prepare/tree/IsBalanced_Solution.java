package bjtu_prepare.tree;

/*
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced_Solution {
	private boolean res = true;

	public boolean isBalanced(TreeNode root) {

		if (root == null) {
			// 空树认为是平衡二叉树
			return true;
		}
		getDepth(root);

		return res;
	}

	public int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// while(root!=null){
		int left = getDepth(root.left);
		int right = getDepth(root.right);

		if (Math.abs(left - right) > 1) {
			res = false;
		}
		return (left > right) ? left + 1 : right + 1;
		// }
	}
}
