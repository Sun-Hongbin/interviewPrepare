package bjtu_prepare.other;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 示例:

 输入: x = 1, y = 4
 输出: 2

 解释:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 上面的箭头指出了对应二进制位不同的位置。
 * @author SuperBin
 *
 */
public class HammingDistance {
	public static void main(String[] args){
		hammingDistance(4,1);
	}

	public static int hammingDistance(int x, int y) {
		int res = 0;

		String s1 = Integer.toBinaryString(x);
		String s2 = Integer.toBinaryString(y);
		int len1 = s1.length();
		int len2 = s2.length();

		while (len1 > len2) {
			s2 = "0" + s2;
			len2++;
		}
		while (len1 < len2) {
			s1 = "0" + s1;
			len1++;
		}
		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();
		for (int i = 0; i < len1; i++) {
			if (a[i] != b[i]) {
				res++;
			}
		}
		return res;
	}
}
