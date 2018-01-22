package back.step_5.If;

import java.util.ArrayList;
import java.util.Scanner;

public class P10871 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int x = scan.nextInt();
		int a[] = new int[N];
		ArrayList<Integer> arrayList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			a[i] = scan.nextInt();
		}

		for (int i = 0; i < N; i++)
			if (a[i] < x) {
				arrayList.add(a[i]);
			}

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i) + " ");
		}
	}

}
