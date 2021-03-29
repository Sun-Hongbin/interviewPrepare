package bjtu_prepare.other;

import java.util.Arrays;

public class ReverseSentence {

	public String reverse(String str) {
		if (str.trim().length() == 0) {
			return str;
		}
		StringBuffer sb = new StringBuffer();
		String[] s = str.split(" ");
		System.out.println(Arrays.toString(s));
		for (int i = s.length - 1; i > 0; i--) {
			sb.append(s[i]).append(" ");
			System.out.println(String.valueOf(sb));
		}
		sb.append(s[0]);
		System.out.println(String.valueOf(sb));
		return String.valueOf(sb);
	}

	public static void main(String[] args) {
		String str = "student! a am I";
		ReverseSentence r = new ReverseSentence();
		System.out.println(r.reverse(str));
	}
}
