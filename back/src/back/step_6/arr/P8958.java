package back.step_6.arr;

import java.util.ArrayList;
import java.util.Scanner;

public class P8958 {
	public static void main(String[] args) {
		int count = 0;
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> arrayList = new ArrayList();
		count = scan.nextInt();
		scan.nextLine();

		while (count != 0) {
			String testCase = scan.nextLine();
			int tempscore[] = new int[testCase.length()];
			int sumScore = 0;
			if (testCase.charAt(0) == 'O') {
				tempscore[0] = 1;
			}
			for (int i = 1; i < testCase.length(); i++) {
				if (testCase.charAt(i - 1) == 'O' && testCase.charAt(i) == 'O') {
					tempscore[i] = 1+tempscore[i - 1];
				} else if (testCase.charAt(i) == 'O') {
					tempscore[i] = 1;
				}

			}
			for (int i = 0; i < tempscore.length; i++) {
				sumScore = sumScore + tempscore[i];
			}
			arrayList.add(sumScore);
			count--;
		}

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}

	}
}
