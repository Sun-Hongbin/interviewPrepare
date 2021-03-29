package bjtu_prepare.other;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Wangyi {

	public String permutation(int n, int m, int k) {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> result = new ArrayList<>();
		if (n == 0 && m == 0 || k == 0) {
			return null;
		}
		for (int i = 0; i < n; i++) {
			sb.append('a');
		}
		for (int i = 0; i < m; i++) {
			sb.append('z');
		}
		String str = sb.toString();
		char[] chars = str.toCharArray();
		TreeSet<String> temp = new TreeSet<>();
		permutation(chars, 0, temp);
		result.addAll(temp);
		result.get(k - 1);
		return result.get(k - 1);
	}

	public void permutation(char[] chars, int index, TreeSet<String> result) {
		if (chars == null || chars.length == 0) {
			return;
		}
		if (index < 0 || index > chars.length - 1) {
			return;
		}
		if (index == chars.length - 1) {
			result.add(String.valueOf(chars));
		} else {
			for (int i = index; i <= chars.length - 1; i++) {
				swap(chars, index, i);
				permutation(chars, index + 1, result);
				swap(chars, index, i);
			}
		}

	}

	public void swap(char[] c, int a, int b) {
		char temp = c[a];
		c[a] = c[b];
		c[b] = temp;
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Wangyi wangyi = new Wangyi();
		while (in.hasNextInt()) {// 注意while处理多个case
			int n = in.nextInt();
			int m = in.nextInt();
			int k = in.nextInt();
			System.out.println(wangyi.permutation(n, m, k));
		}


	}
}
