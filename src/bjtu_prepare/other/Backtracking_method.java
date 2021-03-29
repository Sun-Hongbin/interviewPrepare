package bjtu_prepare.other;

/**
 * @author SuperBin
 *
 * @date: 2018年12月24日
 */
public class Backtracking_method {

	/*
	 * 第一题、请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
	 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s
	 * f c s a d e e 这样的3 X 4矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
	 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
	 */
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {

		int[] flag = new int[matrix.length];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (helper(matrix, i, j, rows, cols, 0, str, flag)) {
					return true;
				}
			}
		}
		return false;

	}

	public boolean helper(char[] matrix, int i, int j, int rows, int cols, int k, char[] str, int[] flag) {

		int index = i * cols + j;

		if (i < 0 || i >= rows || j < 0 || j >= cols || str[k] != matrix[index] || flag[index] == 1) {
			return false;
		}

		if (k == str.length - 1) {
			return true;
		}

		flag[index] = 1;

		if (helper(matrix, i + 1, j, rows, cols, k + 1, str, flag)
				|| helper(matrix, i - 1, j, rows, cols, k + 1, str, flag)
				|| helper(matrix, i, j + 1, rows, cols, k + 1, str, flag)
				|| helper(matrix, i, j - 1, rows, cols, k + 1, str, flag)) {
			return true;
		}

		flag[index] = 0;
		return false;
	}

	/*
	 * 第二题、地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
	 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 =
	 * 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
	 */

	public int movingCount(int threshold, int rows, int cols) {

		int[][] flag = new int[rows][cols];

		return help(0, 0, rows, cols, threshold, flag);
	}

	public int help(int i, int j, int rows, int cols, int threshold, int[][] flag) {

		if (i < 0 || i >= rows || j < 0 || j >= cols || flag[i][j] == 1 || sumOfInt(i) + sumOfInt(j) > threshold) {
			return 0;
		}

		flag[i][j] = 1;

		return 1 + help(i + 1, j, rows, cols, threshold, flag) + help(i - 1, j, rows, cols, threshold, flag)
				+ help(i, j + 1, rows, cols, threshold, flag) + help(i, j - 1, rows, cols, threshold, flag);
	}

	public int sumOfInt(int i) {
		int sum = 0;
		while (i != 0) {
			sum += i % 10;
			i = i / 10;
		}
		return sum;
	}







	public static void main(String[] args) {

		Backtracking_method b = new Backtracking_method();
		char[] matrix = { 'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E' };
		char[] str = { 'S', 'E', 'E' };
		System.out.println(b.hasPath(matrix, 3, 4, str));
	}
}
