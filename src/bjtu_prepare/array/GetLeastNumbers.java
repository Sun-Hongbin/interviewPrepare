package bjtu_prepare.array;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author SuperBin
 *
 * @date: 2018年12月11日
 */
public class GetLeastNumbers {

	public static void main(String[] args) {
		GetLeastNumbers g = new GetLeastNumbers();
		int[] input = { 4, 5, 1, 6, 2, 7, 3, 8 };
		System.out.println(g.getLeastNumbersSolution(input, 4).toString());
	}

	public ArrayList<Integer> getLeastNumbersSolution(int[] input, int k) {

		ArrayList<Integer> list = new ArrayList<>();

		if (input == null || input.length < k || k <= 0) {
			return list;
		}

		int[] kArray = Arrays.copyOfRange(input, 0, k);

		buildHeap(kArray);

		for (int i = k; i < input.length; i++) {
			if (input[i] < kArray[0]) {
				kArray[0] = input[i];
				adjustToMaxHeap(kArray, 0);
			}
		}

		for (int i = 0; i < k; i++) {
			list.add(kArray[i]);
		}

		return list;
	}

	public void buildHeap(int[] input) {
		for (int i = input.length / 2 - 1; i >= 0; i--) {
			adjustToMaxHeap(input, i);
		}
	}

	public void adjustToMaxHeap(int[] input, int i) {

		int left = i * 2 + 1;
		int right = left + 1;
		int largest = 0;

		if (left < input.length && input[left] > input[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right < input.length && input[right] > input[largest]) {
			largest = right;
		}

		if (largest != i) {
			int temp = input[i];
			input[i] = input[largest];
			input[largest] = temp;
			adjustToMaxHeap(input, largest);
		}

	}
}
