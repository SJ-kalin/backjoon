	package back.step_04.If;
	
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.HashMap;
	import java.util.Scanner;
	
	public class P4344 {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			int TestCase = scanner.nextInt();
			int score[][] = new int[TestCase][];
			double avg[] = new double[TestCase];
			for (int i = 0; i < TestCase; i++) {
				int temp = scanner.nextInt();
				score[i] = new int[temp];
				for (int j = 0; j < temp; j++) {
					score[i][j] = scanner.nextInt();
				}
			}
	
			for (int i = 0; i < TestCase; i++) {
				int sum = 0;
				int count = 0;
				for (int j = 0; j < score[i].length; j++) {
					sum = sum + score[i][j];
				}
				avg[i] = sum / (double) (score[i].length);
				for (int k = 0; k < score[i].length; k++) {
					if (score[i][k] > avg[i]) {
						count++;
					}
				}
				System.out.printf("%.3f%%\n", (double) count / (double) score[i].length * 100);
			}
			// for (int i = 0; i < TestCase; i++) {
			// System.out.println(Arrays.toString(score[i]));
			// }
		}
	}
