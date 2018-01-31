package back.step_7.str;

import java.util.Arrays;
import java.util.Scanner;

public class P10809 {
	public static void main(String[] args) {
		String word = "";
		Scanner scan = new Scanner(System.in);
		int arr[] = new int[26];
		Arrays.fill(arr, -1);
		word = scan.nextLine();
		for (int i = 0; i < word.length(); i++) {
			char temp = word.charAt(i);
			int order = temp - 'a';
			if (arr[order] == -1) {
				arr[order] = i;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
