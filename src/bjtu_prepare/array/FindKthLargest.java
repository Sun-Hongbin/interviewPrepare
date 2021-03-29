package bjtu_prepare.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargest {
	public static int findKthLargest1(int[] array, int k) {

		if (array == null || k < 1) {
			return 0;
		}

		// 用JAVA自带的排序方式, 时间复杂度为O(nlog(n))。
		Arrays.sort(array);
		return array[array.length - k];
	}

	public static int findKthLargest2(int[] array, int k) {

		if (array == null || k < 1) {
			return 0;
		}

		// 堆排序, 时间复杂度为O(nlog(k))，空间复杂度为 O(k) 。
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int num : array) {
			queue.offer(num);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		int res = queue.peek();
		return res;
	}

	public static int findKthLargest3(int[] array, int k) {

		// 快速排序：适合用于数据量大的情况
		// 平均时间复杂度为O(n)，最坏情况下为O(n^2)。
		int res = 0;
		return res;

	}

	public static void main(String[] args) {
		int[] arr = { 5, 6, 4, 3, 2, 1, 7, 8, 9, 10 };
		System.out.println(findKthLargest1(arr, 2));
		System.out.println(findKthLargest2(arr, 2));
	}
}
