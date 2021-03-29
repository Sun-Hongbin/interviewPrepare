package bjtu_prepare.binTreeTraversal;

import java.util.Stack;

public class Traversal {

    /**
     * construct a binary tree
     * <p>
     * 1 2 3 4 5 6 7 8 9
     */

    // create a rootNode
    private TreeNode root = null;

    public Traversal() {
        root = new TreeNode(1);
    }

    // create myTree
    public void createTree() {
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.leftChild = node2;
        root.rightChild = node3;
        root.leftChild.leftChild = node4;
        root.leftChild.rightChild = node5;
        root.rightChild.rightChild = node6;
        root.leftChild.leftChild.rightChild = new TreeNode(7);
        root.leftChild.rightChild.leftChild = new TreeNode(8);
        root.leftChild.rightChild.rightChild = new TreeNode(9);
    }

    public void printNode(TreeNode node) {
        node.isVisited = true;
        System.out.print("node:" + node.data + " ");
    }

    /**
     * non-recursive
     */
    public void preOrder(TreeNode root) {
        if (root != null) {
            printNode(root);
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }

    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.leftChild);
            printNode(root);
            inOrder(root.rightChild);
        }

    }

    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            printNode(root);
        }

    }

    /**
     * non-recursive method
     */

    // push时输出
    public void nonRecPreOrder1(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            while (node != null) {
                printNode(node);
                stack.push(node);
                node = node.leftChild;
            }
            if (stack.size() > 0) {
                node = stack.pop();
                node = node.rightChild;
            }
        }

    }

    // pop时输出（更正规）
    public void nonRecPreOrder2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            while (node != null) {
                printNode(node);
                if (node.rightChild != null) {
                    stack.push(node.rightChild);
                }
                node = node.leftChild;
            }
        }
    }

    public void nonRecInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            if (stack.size() > 0) {
                node = stack.pop();
                printNode(node);
                node = node.rightChild;
            }
        }
    }

    public void nonRecPostOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> out = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                out.push(node);
                node = node.rightChild;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.leftChild;
            }
        }
        while (out.size() > 0) {
            printNode(out.pop());
        }
    }

    public static void main(String[] args) {

        Traversal tra = new Traversal();
        tra.createTree();
        System.out.println("************先序遍历*************");
        tra.nonRecPreOrder1(tra.root);
        System.out.println("\n************先序遍历(正规)*************");
        tra.nonRecPreOrder2(tra.root);
        System.out.println("\n************中序遍历*************");
        tra.nonRecInOrder(tra.root);
        System.out.println("\n************后序遍历(双栈法)*************");
        tra.nonRecPostOrder(tra.root);

    }
}
