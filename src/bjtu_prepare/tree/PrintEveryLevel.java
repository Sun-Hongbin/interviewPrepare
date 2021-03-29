package bjtu_prepare.tree;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * @author SuperBin
 */

public class PrintEveryLevel {

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {

        //放每一行的结果
        ArrayList<Integer> list = new ArrayList<>();
        //储存层序遍历结果
        LinkedList<TreeNode> queue = new LinkedList<>();
        //放最终输出结果
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        queue.add(pRoot);
        int start = 0;
        int end = 1;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.pop();
            list.add(temp.val);
            start++;

            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }

            //必须放这里，因为queue要先加后才能得到size再给end赋值
            if (start == end) {
                start = 0;
                end = queue.size();
                res.add(new ArrayList<>(list));
                list.clear();
            }
        }
        return res;

    }

}
