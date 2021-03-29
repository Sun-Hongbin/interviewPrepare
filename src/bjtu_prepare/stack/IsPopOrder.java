package bjtu_prepare.stack;

import java.util.Stack;

/*
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {
	public static void main(String[] args) {
		int[] push = { 1, 2, 3, 4, 5 };
		int[] pop = { 4, 5, 3, 2, 1 };
		System.out.println(IsPopOrder(push, pop));
	}

	public static boolean IsPopOrder(int[] pushA, int[] popA) {
		if (pushA == null || popA == null) {
			return false;
		}
		int index = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while (!stack.isEmpty() && stack.peek() == popA[index]) {
				// while (stack.peek() == popA[index] && !stack.isEmpty())
				// {！！！！！划重点！！！！！不判断空或者顺序错误都会报错，stack.peek()需要有元素
				// 错误是java.util.EmptyStackException
				stack.pop();
				index++;
			}
		}
		return stack.isEmpty();

	}
}
