package bjtu_prepare.tree;

public class TreeDepth {

	public int treeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int i = treeDepth(root.left);
		int j = treeDepth(root.right);
		return (i > j) ? (i + 1) : (j + 1);
	}
}
