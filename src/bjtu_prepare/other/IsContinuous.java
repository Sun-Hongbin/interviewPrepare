package bjtu_prepare.other;

import java.util.Arrays;

/**
 * LL买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张),他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子
 * “红心A,黑桃3,小王,大王,方片5”,不是顺子.....LL不高兴了,他想了想,决定大\小王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4)LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为 大小王是0。
 *
 * @author SuperBin
 *
 * @date: 2018年12月18日
 *
 * 思路：只要0出现的个数大于等于需要的间隔数，就能满足顺子的要求，本题只想要求顺子的判断，不是运气的判断。。
 */
public class IsContinuous {

	public static void main(String[] args) {

		int[] a = {3,0,0,0,5};
		IsContinuous i = new IsContinuous();
		System.out.println(i.isContinuous(a));
	}


	public boolean isContinuous(int [] numbers) {

		if(numbers == null || numbers.length != 5) {
			return false;
		}

		int numOfZero = 0;
		int numOfInterval = 0;

		Arrays.sort(numbers);

		for(int i = 0; i < numbers.length - 1; i++){

			if(numbers[i] == 0) {
				numOfZero++;
				continue;
			}

			if(numbers[i] == numbers[i + 1]){
				return false;//出现对子
			}else{
				numOfInterval += numbers[i + 1] - numbers[i] - 1;
			}

		}

		if(numOfZero >= numOfInterval){
			return true;
		}else{
			return false;
		}

	}

}
