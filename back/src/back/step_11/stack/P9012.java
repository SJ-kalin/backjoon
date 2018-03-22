package back.step_11.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		while (--count >= 0) {

			String vps = br.readLine();
			char[] vpsChar = vps.toCharArray();
			ArrayList<Character> stack = new ArrayList();

			// 홀수이면 연산할 필요가 없다.
			if (vpsChar.length % 2 != 0 || vpsChar[0] == ')' || vpsChar[vps.length() - 1] == '(') {
				System.out.println("NO");
				continue;
			}

			for (int i = 0; i < vpsChar.length; i++) {

				if (stack.size() == 0) {
					stack.add(vpsChar[i]);
					continue;
				}

				if (stack.get(stack.size() - 1) == '(' && vpsChar[i] == ')') {
					stack.remove(stack.size() - 1);
				} else {
					stack.add(vpsChar[i]);
				}
			}

			if (stack.size() == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
		br.close();
	}
}
