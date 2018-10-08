package back.step_07.str;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class P2675 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int testCount = 0;
		testCount = scan.nextInt();
		ArrayList<Case> list = new ArrayList();

		for (int i = 0; i < testCount; i++) {
			int tempRepeatCount = scan.nextInt();
			String tempWord = scan.nextLine().trim();
			list.add(new Case(tempRepeatCount, tempWord));
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).word.length(); j++) {
				for (int k = 0; k < list.get(i).repeatCount; k++) {
					System.out.print(list.get(i).word.charAt(j));
				}
			}
			System.out.println();
		}
	}
}

class Case {
	int repeatCount;
	String word;

	public Case(int repeatCount, String word) {
		super();
		this.repeatCount = repeatCount;
		this.word = word;
	}

}
