package bjtu_prepare.other;

/*
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class NumberOf1Between1AndN {
	public static void main(String[] args) {
		int n = 132;
		NumberOf1Between1AndN c = new NumberOf1Between1AndN();
		int k = c.numberOf1Between1AndN(n);
		System.out.println("res=" + k);
	}

	public int numberOf1Between1AndN(int n) {
		if(n < 0) {
			return 0;
		}
		int high, low, curr, temp;
		int count = 0;
		high = n;
		int i = 1;//表示当前位
		while(high != 0){

			high = (int) (n / Math.pow(10, i));
			temp = (int) (n % Math.pow(10, i));
			curr = (int) (temp / Math.pow(10, i-1));
			low = (int) (temp % Math.pow(10, i -1));

			if(curr < 1){
				count += high * Math.pow(10, i -1);
			}
			if(curr == 1){
				count += high * Math.pow(10, i -1) + low + 1;
			}
			if(curr > 1){
				count += (high + 1) * Math.pow(10, i -1);
			}

			i++;
		}

		return count;
	}




	/**
	 * @param n
	 * @param x
	 *            [1,9]
	 * @return
	 */
	public int NumberOfXBetween1AndN_1to9(int n, int x) {
		if (n < 0 || x < 1 || x > 9)
			return 0;
		int high, low, curr, tmp, i = 1;
		high = n;
		int total = 0;
		while (high != 0) {
			high = n / (int) Math.pow(10, i);// 获取第i位的高位
			tmp = n % (int) Math.pow(10, i);
			curr = tmp / (int) Math.pow(10, i - 1);// 获取第i位
			low = tmp % (int) Math.pow(10, i - 1);// 获取第i位的低位
			if (curr == x) {
				total += high * (int) Math.pow(10, i - 1) + low + 1;
			} else if (curr < x) {
				total += high * (int) Math.pow(10, i - 1);
			} else {
				total += (high + 1) * (int) Math.pow(10, i - 1);
			}
			i++;
		}
		return total;
	}

}
