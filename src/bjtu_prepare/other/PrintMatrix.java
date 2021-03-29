package bjtu_prepare.other;
import java.util.ArrayList;

/*
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵：
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 */

public class PrintMatrix {
	public static void main(String[] args) {
		int[][] matrix1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		int[][] matrix2 = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 }, { 9, 10 } };
		int[][] matrix3 = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
		int[][] matrix4 = { { 1, 2, 3, 4, 5 } };
		int[][] matrix5 = { { 1 } };
		System.out.println(printMatrix(matrix1));
		System.out.println(printMatrix(matrix2));
		System.out.println(printMatrix(matrix3));
		System.out.println(printMatrix(matrix4));
		System.out.println(printMatrix(matrix5));
	}

	public static ArrayList<Integer> printMatrix(int[][] matrix) {
		if (matrix == null) {
			return null;
		}
		int start = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (matrix[0].length > start * 2 && matrix.length > start * 2) {
			list = printCircle(matrix, start, list);
			start++;
		}
		return list;

	}

	public static ArrayList<Integer> printCircle(int[][] matrix, int start,
												 ArrayList<Integer> list) {
		int col = matrix[0].length - start;
		int row = matrix.length - start;
		// 从左往右打印
		for (int i = start; i < col; i++) {
			list.add(matrix[start][i]);
		}
		// 从上往下打印（考虑是否有重复打印）
		for (int i = start + 1; i < row; i++) {
			list.add(matrix[i][col - 1]);
		}
		// 从右往左打印（考虑是否有重复打印）
		if (start < row - 1) {
			for (int i = col - 2; i >= start; i--) {
				list.add(matrix[row - 1][i]);
			}
		}
		// 从下到上打印（考虑是否有重复打印）
		if (start < col - 1) {
			for (int i = row - 2; i > start; i--) {
				list.add(matrix[i][start]);
			}
		}
		return list;
	}
}
