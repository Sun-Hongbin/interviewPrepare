package bjtu_prepare.other;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * @author SuperBin
 *
 * @date: 2018年12月21日
 */
public class FirstAppearingOnce {

	StringBuilder sb = new StringBuilder();
	char[] chars = new char[256];

	// Insert one char from stringstream
	public void insert(char ch) {

		sb.append(ch);

		chars[ch]++;
	}

	// return the first appearence once char in current stringstream
	public char firstAppearingOnce() {

		char[] c = sb.toString().toCharArray();

		for (char value : c) {
			if (chars[value] == 1) {
				return value;
			}
		}
		return '#';

	}

}
