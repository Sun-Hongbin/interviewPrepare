package bjtu_prepare.other;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数， 但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * @author SuperBin
 *
 * @date: 2018年12月13日
 */
public class GetUglyNumber {

	public static void main(String[] args) {

		GetUglyNumber g = new GetUglyNumber();
		System.out.println(g.getUglyNumber(0));
	}

	public int getUglyNumber(int index) {

		if (index <= 0) {
			return 0;
		}
		int[] res = new int[index];
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		int count = 0;

		res[0] = 1;
		int temp;

		while (count < index - 1) {

			temp = min(res[i2] * 2, min(res[i3] * 3, res[i5] * 5));
			if (temp == res[i2] * 2) {
				i2++;
			}
			if (temp == res[i3] * 3) {
				i3++;
			}
			if (temp == res[i5] * 5) {
				i5++;
			}
			res[++count] = temp;
		}

		return res[count];
	}

	public int min(int a, int b) {
		return a < b ? a : b;
	}

}
