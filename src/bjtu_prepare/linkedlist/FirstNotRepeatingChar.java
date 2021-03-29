package bjtu_prepare.linkedlist;

import java.util.LinkedHashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 * @author SuperBin
 *
 * @date: 2018年12月13日
 */
public class FirstNotRepeatingChar {

	public static void main(String[] args) {
		FirstNotRepeatingChar f = new FirstNotRepeatingChar();

		System.out.println(f.firstNotRepeatingChar("google") + " ");
	}

	public int firstNotRepeatingChar(String str) {

		if (str == null || str.length() == 0) {
			return -1;
		}

		char[] c = str.toCharArray();

		LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

		for (char item : c) {
			if (map.containsKey(item)) {
				map.put(item, map.get(item) + 1);
			} else {
				map.put(item, 1);
			}
		}

		for (int i = 0; i < c.length; i++) {
			if (map.get(c[i]) == 1) {
				return i;
			}
		}

		return -1;
	}

}
