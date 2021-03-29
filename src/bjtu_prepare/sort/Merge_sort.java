package bjtu_prepare.sort;

import java.util.Arrays;

public class Merge_sort {

	// 统一的函数接口
	public void mergeSort(int[] arr, int n) {

		int[] temp = new int[arr.length];

		mergeSort_divideAndAndRule(arr, temp, 0, arr.length - 1);
		// java内存自动回收机制，不需要释放数组空间，不用的话会自动回收. 但记住这里需要释放空间的
	}

	// 1、递归解法，分而治之
	public void mergeSort_divideAndAndRule(int[] arr, int[] tempArr, int left, int rightEnd) {

		int center;

		if (left < rightEnd) {

			center = (left + rightEnd) / 2;

			mergeSort_divideAndAndRule(arr, tempArr, left, center);
			mergeSort_divideAndAndRule(arr, tempArr, center + 1, rightEnd);
			merge(arr, tempArr, left, center + 1, rightEnd);
		}

		System.out.println(Arrays.toString(arr));
	}

	// 2、非递归解法
	public void mergerSort_nonRecursive() {

	}

	// 核心拍寻，两个有序子序列归并位一个序列
	public void merge(int[] arr, int[] tempArr, int left, int right, int rightEnd) {
		// left = 左边子序列起始位置， rightEnd = 右边子序列右边终点位置

		int leftEnd = right - 1;// 假设两列都挨着

		int temp = left;// 存放结果数组的初始位置

		int numElements = rightEnd - left + 1;

		while (left <= leftEnd && right <= rightEnd) {
			if (arr[left] < arr[right]) {
				tempArr[temp++] = arr[left++];
			} else {
				tempArr[temp++] = arr[right++];
			}
		}

		while (left <= leftEnd) {// 直接复制左边剩下的
			tempArr[temp++] = arr[left++];
		}

		while (right <= rightEnd) {// 直接复制右边剩下的
			tempArr[temp++] = arr[right++];
		}

		for (int i = 0; i < numElements; rightEnd--, i++) {
			arr[rightEnd] = tempArr[rightEnd];
		}
	}

	public static void main(String[] args) {

		Merge_sort m = new Merge_sort();

		int[] arr = { 8, 4, 7, 5, 1, 3, 6, 2 };

		m.mergeSort(arr, 8);

		/**
		 * [8, 4, 7, 5, 1, 3, 6, 2]
		 * [8, 4, 7, 5, 1, 3, 6, 2]
		 * [4, 8, 7, 5, 1, 3, 6, 2]
		 * [4, 8, 7, 5, 1, 3, 6, 2]
		 * [4, 8, 7, 5, 1, 3, 6, 2]
		 * [4, 8, 5, 7, 1, 3, 6, 2]
		 * [4, 5, 7, 8, 1, 3, 6, 2]
		 * [4, 5, 7, 8, 1, 3, 6, 2]
		 * [4, 5, 7, 8, 1, 3, 6, 2]
		 * [4, 5, 7, 8, 1, 3, 6, 2]
		 * [4, 5, 7, 8, 1, 3, 6, 2]
		 * [4, 5, 7, 8, 1, 3, 6, 2]
		 * [4, 5, 7, 8, 1, 3, 2, 6]
		 * [4, 5, 7, 8, 1, 2, 3, 6]
		 * [1, 2, 3, 4, 5, 6, 7, 8]
		 */
	}

}
