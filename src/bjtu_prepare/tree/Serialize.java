package bjtu_prepare.tree;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * @author SuperBin
 *
 * @date: 2018年12月22日
 */
public class Serialize {


	String serialize(TreeNode root) {

		if(root == null) {
			return "#,";
		}

		StringBuffer sb = new StringBuffer();

		sb.append(root.val).append(",");
		sb.append(serialize(root.left));
		sb.append(serialize(root.right));

		return sb.toString();
	}

	public int index = -1;

	TreeNode deserialize(String str) {

		index++;

		String[] a = str.split(",");

		if(index >= a.length) {
			return null;
		}

		TreeNode node = null;

		if(a[index].equals("#")) {
			return null;
		}

		node = new TreeNode(Integer.valueOf(a[index]));
		node.left = deserialize(str);
		node.right = deserialize(str);

		return node;
	}

}
