package back.step_7.str;

import java.util.HashMap;
import java.util.Scanner;

public class P1157 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean isSame = false;
		int maxNum = 0;
		char maxChar = '0';
		String word = scan.nextLine().toLowerCase();

		HashMap<Character, Integer> map = new HashMap();

		for (int i = 0; i < word.length(); i++) {
			if (!map.containsKey(word.charAt(i))) {
				map.put(word.charAt(i), 1);
			} else {
				map.replace(word.charAt(i), map.get(word.charAt(i)) + 1);
			}
		}
		for (char key : map.keySet()) {
			if (map.get(key) > maxNum) {
				maxNum = map.get(key);
				maxChar = key;
				isSame = false;
			} else if (map.get(key) == maxNum) {
				isSame = true;
			}
		}

		if (isSame) {
			System.out.println("!");
		} else {
			System.out.printf("%c", Character.toUpperCase(maxChar));
		}

	}
}
