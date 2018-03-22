package back.step_11.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P10828 {

	static int STACK[] = new int[100000];
	static int INDEX = -1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		StringTokenizer token;
		for (int i = 0; i < count; i++) {
			String temp = br.readLine();
			token = new StringTokenizer(temp);
			command(token);
		}
	}

	private static void command(StringTokenizer token) {
		String commandWord = token.nextToken();
		if (commandWord.equals("push")) {
			callpush(token.nextToken());
		} else if (commandWord.equals("top")) {
			callTop();
		} else if (commandWord.equals("size")) {
			callSize();
		} else if (commandWord.equals("empty")) {
			callEmpty();
		} else if (commandWord.equals("pop")) {
			callPop();
		} else {
			callError();
		}
	}

	private static void callError() {
		System.out.println("error!");
	}

	private static void callPop() {
		if (INDEX == -1) {
			System.out.println(-1);
		} else {
			System.out.println(STACK[INDEX]);
			INDEX--;
		}
	}

	private static void callEmpty() {
		if (INDEX == -1) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	private static void callSize() {
		System.out.println(INDEX + 1);
	}

	private static void callTop() {
		if (INDEX == -1) {
			System.out.println(-1);
		} else {
			System.out.println(STACK[INDEX]);
		}
	}

	private static void callpush(String nextToken) {
		STACK[++INDEX] = Integer.parseInt(nextToken);
	}
}
