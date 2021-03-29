package bjtu_prepare.sort;

import java.util.Arrays;

public class Bubble_sort {

	public static void main(String[] args) {
		int[] a = {21,2,4,5,1,0,7,3};
		bubble_recur(a, 8);
		System.out.println(Arrays.toString(a));
	}
	
	public static int[] bubble_sort(int[] arr, int n) {

		for (int i = n - 1; i >= 0; i--) {
			int flag = 0;
			for (int j = 0; j < i; j++) {//one time sort
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j+1);
					flag = 1;//flag change
				}
			}
			if (flag == 0) {//After one sorting, adjacent number didn't swap, then it's a ordered array.
				break;
			}
		}
		return arr;
	}
	
	public static int[] bubble_recur(int[] arr, int n) {
		
		int flag = 0;
		
		for(int i = 0; i < n - 1; i++) {
			if(arr[i] > arr[i + 1]) {
				swap(arr, i, i + 1);
				flag = 1;
			}
		}
		
		if(flag == 0) {
			return arr;
		} else {
			bubble_recur(arr, n -1);
		}
		
		return arr;
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
