package bjtu_prepare.sort;

public class Insertion_sort {

	public int[] insertion_sort(int[] arr, int n) {

		for (int i = 1; i < n; i++) {
			int temp = arr[i];// get card
			for (int j = i; j > 0 && arr[j - 1] > temp; j--) {
				arr[j] = arr[j-1];//move
				arr[j-1] = temp;//card find its location
			}
		}
		return arr;
	}
}
