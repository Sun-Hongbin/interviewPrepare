package bjtu_prepare.string;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * @author SuperBin
 *
 * @date: 2018年12月20日
 */
public class StrToInt {

	public static void main(String[] args){

		StrToInt s = new StrToInt();
		System.out.println(s.strToInt("-33a2"));
	}

	public int strToInt(String str) {

		if(str == null || str.length() == 0) {
			return 0;
		}

		char[] c = str.toCharArray();

		int isNegative = 0;
		int res = 0;
		int i = 0;

		if(c[0] == '-') {
			isNegative = 1;
			i++;
		}

		for(i = isNegative; i < c.length; i++) {
			if(c[i] == '+') {
				continue;
			}

			if(c[i] > 57 || c[i] < 48) {
				return 0;
			}else {
				res = res * 10 + c[i] - 48;
			}
		}
		return isNegative == 0?res:-res;
	}

}
