package bjtu_prepare.other;


import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ReverseSentenceWords {

	public static String reverseWords(String sentence) {
		StringBuilder sb = new StringBuilder(sentence.length() + 1);
		String[] words = sentence.split(" ");
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i]).append(' ');
			System.out.println(sb);
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner in = new Scanner(System.in);
		System.out.printf("Please input how many lines you want to enter: ");
		String[] input = new String[in.nextInt()];
		in.nextLine();
		for (int i = 0; i < input.length; i++) {
			input[i] = in.nextLine();
		}
		System.out.printf("\nYour input:\n");
		for (String s : input) {
			System.out.println(reverseWords(s));
		}
	}
}
