package back.step_11.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P1918 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		List<String> list = covertPostfix(word);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
	}

	private static List<String> covertPostfix(String infix) {
		Stack<String> S = new Stack();
		List<String> L = new ArrayList();
		for (int i = 0; i < infix.length(); i++) {
			String element = infix.substring(i, i + 1);
			if (isNum(element)) {
				L.add(element);
			} else {
				if (element.equals("(")) {
					S.push(element);
				} else if (element.equals(")")) {
					StringBuffer bf = new StringBuffer();
					while (!S.peek().equals("(")) {
						bf.append(S.pop());
					}
					List<String> tempList = covertPostfix(bf.toString());
					L.addAll(tempList);
					S.pop();
				} else if (S.isEmpty() || priority(S.peek()) < priority(element)) {
					S.push(element);
				} else {
					while (!S.isEmpty() && priority(S.peek()) >= priority(element)) {
						L.add(S.pop());
					}
					S.push(element);
				}
			}
		}
		while (!S.isEmpty()) {
			L.add(S.pop());
		}
		return L;
	}

	private static int priority(String peek) {
		int priority = 0;
		switch (peek) {
		case "*":
			priority = 2;
			break;
		case "/":
			priority = 2;
			break;
		case "+":
			priority = 1;
			break;
		case "-":
			priority = 1;
			break;
		}
		return priority;
	}

	private static boolean isNum(String substring) {
		if (substring.equals("*") || substring.equals("/") || substring.equals("+") || substring.equals("-")
				|| substring.equals("(") || substring.equals(")")) {
			return false;
		}
		return true;
	}
}
