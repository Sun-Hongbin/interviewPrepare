package bjtu_prepare.array;

import java.util.Arrays;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author SuperBin
 *
 * @date: 2018年12月15日
 */
public class GetNumberOfK {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 7, 8, 9, 10, 11, 12, 13 };

		GetNumberOfK g = new GetNumberOfK();

		int num = g.getNumberOfK(arr, 7);

		System.out.println(num + "");
	}

	public int getNumberOfK(int[] array, int k) {

		int count = 0;

		if (array == null || array.length == 0) {
			return 0;
		}

		int mid = array.length / 2;

		if (array[mid] < k) {
			count += getNumberOfK(Arrays.copyOfRange(array, mid + 1, array.length), k);//注意这里mid +1
		} else if (array[mid] > k) {
			count += getNumberOfK(Arrays.copyOfRange(array, 0, mid), k);
		} else {
			for (int i = mid; i < array.length; i++) {
				if (array[i] == k) {
					count++;
				} else {
					break;
				}
			}

			for (int i = mid - 1; i >= 0; i--) {
				if (array[i] == k) {
					count++;
				} else {
					break;
				}
			}
		}

		return count;
	}
}
