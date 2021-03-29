package bjtu_prepare.array;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 *
 * @author SuperBin
 *
 * @date: 2018年12月20日
 */
public class Multiply {

	public int[] multiply(int[] array) {

		int length = array.length;

		int[] b = new int[length];

		if(length != 0){
			b[0] = 1;

			for(int i = 1; i < length; i++) {
				b[i] = b[i - 1] * array[i - 1];
			}

			int temp = 1;

			for(int j = length - 2; j >= 0; j--) {
				temp *= array[j + 1];
				b[j] *= temp;
			}
		}

		return b;
	}

}
