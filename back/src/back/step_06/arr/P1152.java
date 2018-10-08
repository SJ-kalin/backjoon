package back.step_06.arr;

import java.util.Scanner;

public class P1152 {
	public static void main(String[] args) {
		String sentence = "";
		Scanner scan = new Scanner(System.in);
		sentence = scan.nextLine();
		int count = 0;
		ho: for (int i = 0; i < sentence.length(); i++) {
			if (sentence.substring(i, i + 1).equals(" ")) {
				continue;
			} else
				for (int j = i; j < sentence.length(); j++) {
					if (j+1 == sentence.length()) {
						count++;
						break ho;
					}
					if (sentence.substring(j, j + 1).equals(" ")) {
						count++;
						i=j-1;
						break;
					}
				}
		}
		System.out.println(count);
	}
}
