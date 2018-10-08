package back.step_03.repeat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P15552 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			String temp = br.readLine();
			StringTokenizer token = new StringTokenizer(temp);

			int a = Integer.parseInt(token.nextToken());
			int b = Integer.parseInt(token.nextToken());

			bw.write(String.valueOf(a + b) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
