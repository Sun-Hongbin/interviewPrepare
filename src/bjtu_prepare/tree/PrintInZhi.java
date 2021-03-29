package bjtu_prepare.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树， 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @author SuperBin
 *
 */
public class PrintInZhi {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();// 存储单行
		Stack<TreeNode> stack1 = new Stack<>();// 储存奇数行，从右到左打印
		Stack<TreeNode> stack2 = new Stack<>();// 储存偶数行，从左到右打印
		if (pRoot == null) {
			return res;
		}
		stack1.push(pRoot);
		int level = 1;// 第x层
		TreeNode node;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			if (level % 2 != 0) {
				while (!stack1.isEmpty()) {
					node = stack1.pop();
					if(node != null){//*必须要加这个验证！否则显示空指针异常！很奇怪！
						list.add(node.val);
						stack2.push(node.left);// 弹出奇数行后储存偶数行
						stack2.push(node.right);
					}
				}
				if(!list.isEmpty()){//*必须要加这个验证！
					res.add(new ArrayList<>(list));//*必须重新new一个，为啥？
					//ArrayList<Integer> list = new ArrayList<>();加在if (level % 2 != 0)下的话就不需要new
					level++;
					list.clear();
				}
			} else {
				while (!stack2.isEmpty()) {
					node = stack2.pop();
					if(node != null){
						list.add(node.val);
						stack1.push(node.right);
						stack1.push(node.left);
					}
				}
				if(!list.isEmpty()){
					res.add(new ArrayList<>(list));
					level++;
					list.clear();
				}
			}
		}
		return res;
	}

}
