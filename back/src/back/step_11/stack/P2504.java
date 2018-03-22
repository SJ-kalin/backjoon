package back.step_11.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class P2504 {
	static final String LB = "(";
	static final String RB = ")";
	static final String SLB = "[";
	static final String SRB = "]";

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String list[] = br.readLine().split("");
		Stack<String> stack = new Stack();
		boolean isOk = true;

		for (int i = 0; i < list.length; i++) {
			// 스택이 비어있다면 무조건 push 한다.
			if (stack.size() == 0) {
				stack.push(list[i]);
				// 만약 첨에 들어오는 인자가 ),] 면 종료한다.
				if (list[i].equals(RB) || list[i].equals(SRB)) {
					isOk = false;
					break;
				}
				continue;
			}
			// 열려있는 방향이 왼쪽이라면 무조건 push 한다.
			if (list[i].equals(LB) || list[i].equals(SLB)) {
				stack.push(list[i]);
				continue;
			}

			if ((list[i].equals(RB))) {
				if (stack.peek().equals(LB)) {
					stack.pop();
					if (!stack.isEmpty() && !isSymbol(stack.peek())) {
						stack.push(Integer.parseInt(stack.pop()) + 2 + "");
					} else {
						stack.push("2");
					}
				} else if (!stack.peek().equals(SLB)) {
					int temp = Integer.valueOf(stack.pop());
					if (stack.peek().equals(LB)) {
						temp = temp * 2;
						stack.pop();
						if (stack.isEmpty() || isSymbol(stack.peek())) {
							stack.push(temp + "");
						} else {
							temp = temp + Integer.parseInt(stack.pop());
							stack.push(String.valueOf(temp));
						}
					} else {
						isOk = false;
						break;
					}
				}
			} else if ((list[i].equals(SRB))) {
				if (stack.peek().equals(SLB)) {
					stack.pop();
					if (!stack.isEmpty() && !isSymbol(stack.peek())) {
						stack.push(Integer.parseInt(stack.pop()) + 3 + "");
					} else {
						stack.push("3");
					}
				} else if (!stack.peek().equals(LB)) {
					int temp = Integer.valueOf(stack.pop());
					if (stack.peek().equals(SLB)) {
						temp = temp * 3;
						stack.pop();
						if (stack.isEmpty() || isSymbol(stack.peek())) {
							stack.push(temp + "");
						} else {
							temp = temp + Integer.parseInt(stack.pop());
							stack.push(String.valueOf(temp));
						}
					} else {
						isOk = false;
						break;
					}
				}
			}

		}
		if (stack.size() != 1 || !isOk) {
			System.out.println(0);
		} else
			System.out.println(stack.peek());
	}

	private static boolean isSymbol(String peek) {
		if (peek.equals(LB) || peek.equals(RB) || peek.equals(SLB) || peek.equals(SRB)) {
			return true;
		}
		return false;
	}
}