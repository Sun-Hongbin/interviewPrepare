package bjtu_prepare.sort;

import java.util.Arrays;

public class Quick_sort {
	int cutoff = 3;// 设置阈值，若小于此数用简单排序更好

	public void quickSort(int[] arr, int n) {
		quickSort(arr, 0, n - 1);
	}

	public void quickSort(int[] arr, int left, int right) {
		System.out.println("每次调用前： " + Arrays.toString(arr));
		if (right - left > cutoff) {
			if (left == right) {
				return;
			}
			if (left + 1 == right) {
				if (arr[left] > arr[right]) {
					swap(arr, left, right);
				}
				return;
			}
			int pivot = median3(arr, left, right);
			System.out.println("主元: " + pivot);
			int i = left;
			int j = right - 1;
			for (;;) {
				while (arr[++i] < pivot) {
				}
				while (arr[--j] > pivot) {
				}
				if (i < j) {
					swap(arr, i, j);
				} else {
					break;
				}
			}
			swap(arr, i, right - 1);
			quickSort(arr, left, i - 1);
			quickSort(arr, i + 1, right);
		}
		Insertion_sort insertSort = new Insertion_sort();
		insertSort.insertion_sort(arr, right - left);
	}

	public int median3(int[] arr, int left, int right) {
		int center = (left + right) / 2;
		if (arr[left] > arr[center]) {
			swap(arr, left, center);
		}
		if (arr[left] > arr[right]) {
			swap(arr, left, right);
		}
		if (arr[center] > arr[right]) {
			swap(arr, center, right);
		}
		swap(arr, center, right - 1);
		return arr[right - 1];
	}

	public void swap(int[] arr, int a, int b) {
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}

	public static void main(String[] args) {
		Quick_sort q = new Quick_sort();
		int[] arr = { 4, 5, 7, 8, 1, 2, 3, 6 };
		q.quickSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));
	}
}
