package bjtu_prepare.other;
public class Add_ {
	/*
	 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
	 */
	public static void main(String[] args) {
		System.out.println(add(6, 2));
	}

	public static int add(int num1, int num2) {
		while (num2 != 0) {
			// 二进制计算每个位置，用异或相加
			int temp = num1 ^ num2;
			System.out.println(temp);
			// 考虑进位，用与，配合左移一位来加1
			num2 = (num1 & num2) << 1;
			System.out.println(num2 + ",");
			num1 = temp;

		}
		return num1;
	}
}
