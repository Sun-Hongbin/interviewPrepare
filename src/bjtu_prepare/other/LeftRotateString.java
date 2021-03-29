package bjtu_prepare.other;

/*
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class LeftRotateString {
	public String leftRotateString(String str, int n) {
		if (str == null || str.length() == 0) {
			return str;
		}
		String front = str.substring(0, n);
		String back = str.substring(n, str.length());
		StringBuffer sb = new StringBuffer();
		sb.append(back);
		sb.append(front);
		return String.valueOf(sb);
	}


	public static void main(String[] args){
		String str = "abcXYZdef";
		LeftRotateString l = new LeftRotateString();
		System.out.println(l.leftRotateString(str, 3));

	}
}
