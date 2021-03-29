package bjtu_prepare.array;

/*
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,2,3,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
	public int moreThanHalfNum(int[] array) {
		int max = array[0];
		int count = 1;

		for (int i = 1; i < array.length; i++) {// as long as count>0, then max
			// is the res;
			System.out.println("array: " + array[i] + "max: " + max);
			if (array[i] == max) {
				count++;
			} else {
				if (count == 0) {
					max = array[i];
					count = 1;
				} else {
					count--;
				}
			}
		}
		int num = 0;
		for (int j : array) {
			if (j == max) {
				num++;
			}
		}
		if (num * 2 > array.length) {
			return max;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 2, 2, 3, 2, 2, 5, 4, 2, 2 };
		MoreThanHalfNum m = new MoreThanHalfNum();
		System.out.println(m.moreThanHalfNum(arr));
	}
}
