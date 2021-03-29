package bjtu_prepare.tree;

/*
 *输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {

	public static void main(String[] args) {

	}

	public boolean hasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null) {
			return false;
		}
		boolean res = false;
		if (root1.val == root2.val) {
			res = Tree1hasTree2(root1, root2);
		}
		// else{用else的逻辑是错误的
		if (!res) {
			return hasSubtree(root1.left, root2)
					|| hasSubtree(root1.right, root2);
		}
		return res;
	}

	public boolean Tree1hasTree2(TreeNode root1, TreeNode root2) {

		if (root2 == null) {
			return true;
		}
		if (root1 == null) {
			return false;
		}
		if (root1.val != root2.val) {
			return false;
		} else {
			return Tree1hasTree2(root1.left, root2.left)
					&& Tree1hasTree2(root1.right, root2.right);
		}
	}

}
