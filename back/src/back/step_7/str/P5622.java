package back.step_7.str;

import java.util.HashMap;
import java.util.Scanner;

public class P5622 {
	public static void main(String[] args) {
		HashMap<Character, Integer> map = new HashMap();
		int value = 3;
		char ch = 'a';
		int tempValue = 2;

		String word = "";
		Scanner scan = new Scanner(System.in);
		word = scan.nextLine().toLowerCase();

		map.put('a', value);
		map.put('d', value + 1);
		map.put('g', value + 2);
		map.put('j', value + 3);
		map.put('m', value + 4);
		map.put('p', value + 5);
		map.put('t', value + 6);
		map.put('w', value + 7);

		for (int i = (int) 'a'; i <= (int) 'z'; i++) {
			if (!map.containsKey(ch)) {
				map.put(ch, tempValue);
			} else {
				tempValue++;
			}
			ch++;
		}
		int sum = 0;
		for (int i = 0; i < word.length(); i++) {
			sum = sum + map.get(word.charAt(i));
		}
		System.out.println(sum);
	}
}
