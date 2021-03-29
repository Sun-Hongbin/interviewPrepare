package bjtu_prepare.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	/*
	 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。 假设每个输入只对应一种答案，且同样的元素不能被重复利用。 示例: 给定nums =
	 * [2, 7, 11, 15], target = 9 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
	 */
	int[] twoSum(int[] array, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			map.put(array[i], i);
		}
		System.out.println("map: " + map);
		for (int i = 0; i < array.length; i++) {
			int complement = target - array[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("no such solution");
	}

	/*
	 * 题目描述 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
	 * 输出描述: 对应每个测试案例，输出两个数，小的先输出。
	 */
	public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		if (array.length < 2 || sum < 3) {
			return list;
		}
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			if (array[low] + array[high] == sum) {
				list.add(array[low]);
				list.add(array[high]);
				break;
			} else if (array[low] + array[high] < sum) {
				low++;
			} else {
				high--;
			}
		}
		return list;// 检验得乘积最小的为第一组，所以不用将所有的组合输出再排序
	}

	/*
	 *找出所有组合
	 */
	public ArrayList<ArrayList<Integer>> findAllWithSum(int[] array, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		int low = 0;
		int high = array.length - 1;
		Arrays.sort(array);//无序则先排序
		while (low < high) {
			if (array[low] + array[high] == sum) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(array[low]);
				list.add(array[high]);
				res.add(list);
				low++;
				high--;
			} else if (array[low] + array[high] < sum) {
				low++;
			} else {
				high--;
			}
		}
		return res;

	}

	public static void main(String[] args) {
		int[] array = { 7, 2, 11, 15, 2 };
		int[] array2 = { 1, 2, 4, 7, 11, 15 };
		int[] array3 = { 2, 1, 3, 4, 5, 6, 7, 8, 9 };
		TwoSum twoSum = new TwoSum();
		System.out.println(Arrays.toString(twoSum.twoSum(array, 9)));
		System.out.println(twoSum.findNumbersWithSum(array2, 15));
		System.out.println(twoSum.findAllWithSum(array3, 10));
	}
}
