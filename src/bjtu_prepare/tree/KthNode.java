package bjtu_prepare.tree;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 * @author SuperBin
 *
 * @date: 2018年12月25日
 */
public class KthNode {

	TreeNode kthNode(TreeNode pRoot, int k)
	{
		if(pRoot == null || k < 1) {
			return null;
		}

		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = pRoot;
		int count = 0;

		while(node != null || stack.size() != 0) {
			while(node != null) {
				stack.add(node);
				node = node.left;
			}
			if(stack.size() != 0){
				node = stack.pop();
				count++;
				if(count == k) {
					return node;
				}
				node = node.right;
			}
		}

		return null;

	}

}
