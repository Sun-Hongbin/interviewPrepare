package bjtu_prepare.tree;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * @author SuperBin
 *
 * @date: 2018年12月10日
 */
public class Convert {

	/*
	 * 方法一：非递归版 解题思路：
	 *  1.核心是中序遍历的非递归算法。
	 *  2.修改当前遍历节点与前一遍历节点的指针指向。
	 */
	public TreeNode binSearchTreeToTwoWayLinkedList(TreeNode root) {

		if (root == null) {
			return null;
		}

		Stack<TreeNode> stack = new Stack<>();

		TreeNode node = root;

		TreeNode pre = null;// 用于保存中序遍历序列的上一节点

		boolean isFirst = true;

		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (stack.size() > 0) {
				node = stack.pop();
				if (isFirst) {
					pre = node;
					root = node;// 把最左边字树最小的节点（中序遍历的第一个节点）作为头节点
					isFirst = false;
				} else {
					pre.right = node;//from left to right print needed
					node.left = pre;//from right to left print needed
					pre = node;
				}
				node = node.right;
			}
		}
		return root;
	}

}
