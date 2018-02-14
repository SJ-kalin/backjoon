package back.step_7.str;

import java.util.Scanner;

public class P2908 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int firstNum = 0;
		int secondNum = 0;
		int firstReverseNum = 0;
		int secondReverseNum = 0;

		firstNum = scan.nextInt();
		secondNum = scan.nextInt();

		firstReverseNum = reverseNum(firstNum);
		secondReverseNum = reverseNum(secondNum);

		if (firstReverseNum > secondReverseNum) {
			System.out.println(firstReverseNum);
		} else {
			System.out.println(secondReverseNum);
		}

	}

	public static int reverseNum(int originNum) {

		StringBuffer buffer = new StringBuffer();
		while (originNum != 0) {
			buffer.append(originNum % 10);
			originNum = originNum / 10;
		}

		return Integer.parseInt(buffer.toString());
	}

}
