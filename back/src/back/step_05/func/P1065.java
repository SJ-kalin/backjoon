package back.step_05.func;

import java.util.Arrays;
import java.util.Scanner;

public class P1065 {
	public static void main(String[] args) {

		int num = 0;
		int count = 0;
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();

		if (num < 100) {
			System.out.println(num);
		} else {
			count = countHan(num);
			System.out.println(count);
		}
	}

	private static int countHan(int num) {

		int count = 99;

		for (int i = num; i > 99; i--) {
			int length = (int) (Math.log10(i) + 1);
			int digit[] = new int[length];
			int temp = i;
			for (int j = 0; j < length; j++) {
				digit[j] = temp % 10;
				temp = temp / 10;
			}
			// System.out.println(Arrays.toString(digit));
			int arr[] = new int[length - 1];
			for (int k = 0; k < arr.length; k++) {
				arr[k] = digit[k] - digit[k + 1];
			}
			// System.out.println(Arrays.toString(arr));
			if (isHan(arr)) {
				count++;
			}
		}
		return count;
	}

	private static boolean isHan(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] != arr[i + 1]) {
				return false;
			}
		}
		return true;
	}
}
