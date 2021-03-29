package bjtu_prepare.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 输入描述:
 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Permutation {

	private int count = 0;

	public static void main(String[] args) {

		Permutation p = new Permutation();
		System.out.println(p.Permutation("abc").toString());
	}

	public ArrayList<String> Permutation(String str) {

		List<String> res = new ArrayList<>();
		if (str != null && str.length() > 0) {
			helper(str.toCharArray(), 0, res);
		}
		Collections.sort(res);
		return (ArrayList<String>)res;
	}

	public void helper(char[] c, int i, List<String> list) {

		if (i == c.length - 1) {
			String val = String.valueOf(c);
			if (!list.contains(val)) {
				list.add(val);
				System.out.println("加入："+val);
			}
		} else {
			// 回溯法
			for (int j = i; j < c.length; j++) {
				swap(c, i, j);
				count++;System.out.println("调用 +1：" + count);
				helper(c, i + 1, list);
				count--;System.out.println("回调 -1：" + count);
				swap(c, i, j);
			}
		}

	}

	public void swap(char[] c, int i, int j) {
		char temp = c[j];
		c[j] = c[i];
		c[i] = temp;
		System.out.println(String.valueOf(c));
	}

}
