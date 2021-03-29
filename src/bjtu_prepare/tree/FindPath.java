package bjtu_prepare.tree;

import java.util.ArrayList;

/*
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */

public class FindPath {
	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> list = new ArrayList<Integer>();

	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
		if (root == null) {
			return res;
		}
		list.add(root.val);
		target -= root.val;
		if (target == 0 && root.left == null && root.right == null) {
			res.add(new ArrayList<Integer>(list));
		}
		findPath(root.left, target);
		findPath(root.right, target);
		list.remove(list.size() - 1);
		return res;
	}
}
