package bjtu_prepare.other;

import java.util.ArrayList;

/*
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 */
public class FindContinuousSequence {
	public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		if (sum < 3) {
			return res;
		}
		int small = 1;
		int big = 2;
		while (small < (sum + 1) / 2) {
			int s = 0;
			for (int i = small; i < big; i++) {
				s += i;
			}
			if (s == sum) {
				for (int i = small; i < big; i++) {
					list.add(i);
				}
				res.add(new ArrayList<>(list));
				list.clear();
				small++;// lack of this step!
			} else if (s < sum) {
				big++;
			} else {
				small++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		FindContinuousSequence f = new FindContinuousSequence();
		System.out.println(f.findContinuousSequence(100));
	}
}
