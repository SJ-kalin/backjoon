package back.step_5.If;

import java.util.Scanner;

public class P1110 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int clone = num;
		int count = 0;
		do {
			int first = clone / 10;
			int second = clone % 10;
			int sum = (first + second) % 10;
			clone = second * 10 + sum;
		} while (num != clone);
		System.out.println(count);
	}
}
