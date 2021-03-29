package bjtu_prepare.string;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 思路：逐个字符进行判断，e/E/.只能出现任意一个且只出现一次且不能在第一个位置或者是最后一个位置。
 * +-号前一个字符必须是e/E，不能出现除了e/E以外的英文字母。 总之，考虑当前位的前一位是否满足就行
 *
 * @author SuperBin
 *
 * @date: 2018年12月18日
 */
public class IsNumeric {

	public static void main(String[] args) {

		char[] c = { '-', '1', '2', '3', '.', '4', '5','E', '+', '6' };
		System.out.println(isNumeric(c));
	}

	public static boolean isNumeric(char[] str) {
		if (str.length == 0 || str == null) {
			return false;
		}

		int index = 0;
		int eCount = 0;
		int dotCount = 0;

		if (str[0] == '-' || str[0] == '+') {
			index++;
		}

		for (int i = index; i < str.length; i++) {

			if (str[i] == '+' || str[i] == '-') {
				if (str[i - 1] != 'e' && str[i - 1] != 'E') {
					return false;
				}
				continue;
			}

			if (str[i] == 'e' || str[i] == 'E') {
				eCount++;
				if (eCount > 1) {
					return false;
				}
				if (i == 0 || i == str.length - 1 || str[i - 1] < 48 || str[i - 1] > 57) {
					return false;
				}
				dotCount++;
				continue;
			}

			//放在e判断的后面
			if (str[i] == '.') {
				dotCount++;
				if (dotCount > 1) {
					return false;
				}
				continue;
			}

			// 出现非数字且不是e/E则返回false(小数点和符号已经用continue跳过)
			if ((str[i] < 48 || str[i] > 57) && (str[i] != 'e' || str[i] != 'E')) {
				return false;
			}
		}

		return true;
	}

}
