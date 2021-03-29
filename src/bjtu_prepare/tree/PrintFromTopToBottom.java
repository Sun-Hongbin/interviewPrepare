package bjtu_prepare.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 层序遍历，从上往下打印出二叉树的每个节点，同层节点从左至右打印
 */
public class PrintFromTopToBottom {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            list.add(temp.val);
            if (temp.left != null) {
                queue.addLast(temp.left);
            }
            if (temp.right != null) {
                queue.addLast(temp.right);
            }
        }
        return list;
    }

}
