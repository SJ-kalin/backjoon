package back.step_07.str;

import java.util.HashMap;
import java.util.Scanner;

public class P2941 {
	static HashMap<String, String> croatian = new HashMap();
	static String word = "";
	static int countCroatianAlpabet = 0;
	static int index = 0;

	public static void main(String[] args) {
		croatian.put("c=", "c=");
		croatian.put("c-", "c-");
		croatian.put("dz=", "dz=");
		croatian.put("d-", "d-");
		croatian.put("lj", "lj");
		croatian.put("nj", "nj");
		croatian.put("s=", "s=");
		croatian.put("z=", "z=");
		Scanner scan = new Scanner(System.in);
		word = scan.nextLine();
		while (index < word.length()) {
			if (word.length() - index >= 3) {
				checkWithThreeAlphabet();
			} else if (word.length() - index >= 2) {
				checkWithTwoAlphabet();
			} else {
				index++;
				countCroatianAlpabet++;
			}
		}

		System.out.println(countCroatianAlpabet);

	}

	private static void checkWithTwoAlphabet() {
		countCroatianAlpabet++;
		String temp = word.substring(index, index + 2);
		for (String key : croatian.keySet()) {
			if (croatian.get(key).equals(temp)) {
				index += 2;
				break;
			}
		}
		index++;
	}

	private static void checkWithThreeAlphabet() {
		countCroatianAlpabet++;
		String temp = word.substring(index, index + 2);
		for (String key : croatian.keySet()) {
			if (croatian.get(key).equals(temp)) {
				index += 2;
				return;
			}
		}
		temp = word.substring(index, index + 3);
		if (temp.equals(croatian.get("dz="))) {
			index += 3;
			return;
		}
		index++;
	}
}
