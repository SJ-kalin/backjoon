package back.step_4.If;

import java.util.Scanner;

public class P1546 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int subjectNum = scan.nextInt();
		double point[] = new double[subjectNum];
		for (int i = 0; i < point.length; i++) {
			point[i] = scan.nextDouble();
		}
		double max = findMax(point);
		fixPoint(point, max);
		double avg = findAvg(point);
		System.out.printf("%.2f", avg);
	}

	private static double findAvg(double[] point) {
		double sum = 0;
		for (int i = 0; i < point.length; i++) {
			sum = sum + point[i];
		}
		return sum / (double)(point.length);
	}

	private static void fixPoint(double[] point, double max) {
		for (int i = 0; i < point.length; i++) {
			point[i] = point[i] / max * 100.00;
		}

	}

	private static double findMax(double[] point) {
		double temp = point[0];

		for (int i = 0; i < point.length; i++) {
			if (point[i] > temp) {
				temp = point[i];
			}
		}
		return temp;
	}
}
