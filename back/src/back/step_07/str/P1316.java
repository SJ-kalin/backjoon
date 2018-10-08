package back.step_07.str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class P1316 {
	public static void main(String[] args) {
		int TestCase = 0;
		Scanner scan = new Scanner(System.in);
		ArrayList<String> list = new ArrayList();
		int groupWordNum = 0;

		TestCase = scan.nextInt();

		for (int i = 0; i < TestCase; i++) {
			String temp = scan.next();
			list.add(temp);
		}

		for (int i = 0; i < list.size(); i++) {
			HashMap<Character, Boolean> map = new HashMap();
			boolean isGroupWord = true;
			for (int j = 0; j < list.get(i).length(); j++) {
				if (!map.containsKey(list.get(i).charAt(j))) {
					map.put(list.get(i).charAt(j), true);
				} else {
					if (list.get(i).charAt(j - 1) == list.get(i).charAt(j)) {
						continue;
					} else {
						isGroupWord = false;
						break;
					}
				}
			}
			if (isGroupWord) {
				groupWordNum++;
			}
		}
		System.out.println(groupWordNum);
	}
}
