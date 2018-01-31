package back.step_6.arr;

import java.util.Scanner;

public class P2920 {
	public static void main(String[] args) {

		int ORDER = 0;
		final int ORDER_MIXED = 1;
		final int ORDER_ASCE = 2;
		final int ORDER_DESC = 3;

		int melody[] = new int[8];
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < melody.length; i++) {
			melody[i] = scan.nextInt();
		}

		cal: if (melody[0] == 1) {
			for (int i = 1; i < melody.length - 1; i++) {
				if (melody[i] > melody[i + 1]) {
					ORDER = ORDER_MIXED;
					break cal;
				}
			}
			ORDER = ORDER_ASCE;
		} else if (melody[0] == 8) {
			for (int i = 1; i < melody.length - 1; i++) {
				if (melody[i] < melody[i + 1]) {
					ORDER = ORDER_MIXED;
					break cal;
				}
			}
			ORDER = ORDER_DESC;
		} else {
			ORDER = ORDER_MIXED;
		}

		switch (ORDER) {
		case ORDER_ASCE:
			System.out.println("ascending");
			break;

		case ORDER_DESC:
			System.out.println("descending");
			break;

		case ORDER_MIXED:
			System.out.println("mixed");
			break;
		}

	}
}
