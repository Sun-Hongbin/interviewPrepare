package bjtu_prepare.tree;

public class FindParentNode {

	TreeNode root;

	public TreeNode find(TreeNode node) {
		return (node == null || root == node) ? null : find2(root, node);
	}

	public TreeNode find2(TreeNode subTree, TreeNode node) {

		if (subTree == null) {
			return null;
		}
		if (subTree.left == node || subTree.right == node) {
			return subTree;
		}
		// first, find in left subTree
		TreeNode res;
		if ((res = find2(subTree.left, node)) != null) {
			return res;
		} else {
			// find in right subTree
			return find2(subTree.right, node);
		}

	}

}
