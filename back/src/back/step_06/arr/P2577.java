package back.step_06.arr;

import java.util.Scanner;

public class P2577 {
	public static void main(String[] args) {
		int firstNum = 0;
		int secondNum = 0;
		int thirdNum = 0;
		int multipleNum = 0;
		int arr[] = new int[10];
		Scanner scan = new Scanner(System.in);
		firstNum = scan.nextInt();
		secondNum = scan.nextInt();
		thirdNum = scan.nextInt();

		multipleNum = firstNum * secondNum * thirdNum;
		while (multipleNum != 0) {
			int firstDigit = multipleNum % 10;
			multipleNum = multipleNum /10;
			switch (firstDigit) {
			case 0:
				arr[0]++;
				break;
			case 1:
				arr[1]++;
				break;
			case 2:
				arr[2]++;
				break;
			case 3:
				arr[3]++;
				break;
			case 4:
				arr[4]++;
				break;
			case 5:
				arr[5]++;
				break;
			case 6:
				arr[6]++;
				break;
			case 7:
				arr[7]++;
				break;
			case 8:
				arr[8]++;
				break;
			case 9:
				arr[9]++;
				break;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
