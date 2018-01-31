package back.step_6.arr;

import java.util.Scanner;

public class P10039 {
	public static void main(String[] args) {

		int score[] = new int[5];
		int sumScore = 0;
		int avgScore = 0;
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < score.length; i++) {
			int temp = scan.nextInt();
			if (temp < 40) {
				score[i] = 40;
			} else {
				score[i] = temp;
			}
			sumScore = sumScore + score[i];
		}
		avgScore = sumScore / score.length;
		System.out.println(avgScore);
	}
}
