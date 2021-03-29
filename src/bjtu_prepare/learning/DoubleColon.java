package bjtu_prepare.learning;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author SuperBin
 *
 * @date: 2020年7月20日
 */
public class DoubleColon {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("a", "b", "c");

		// 使用遍历的方法
//		for (String word : list) {
//			printValue(word);
//		}

		// 使用Lambda表达式： (变量) -> {代码块}，如果代码块只有一个表达式，大括号可以省略
		// list.forEach((word) -> DoubleColon.printValue(word));
/*		list.forEach(word -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			DoubleColon.printValue(word);
		});*/

		// ::是类似于C++的域运算符，获取方法使用的
		list.forEach(DoubleColon::printValue);

		System.out.println(exist());
	}

	public static void printValue(String word) {
		System.out.println(word);
	}

	public static boolean exist() {
		return new File("D:/c").exists();
	}
}
