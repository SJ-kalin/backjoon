package back.step_9.sort;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P1181 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, ArrayList<String>> map = new HashMap();

		int count = Integer.parseInt(br.readLine());
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < count; i++) {
			builder.append(br.readLine());
			if (!map.containsKey(builder.length())) {
				ArrayList<String> tempList = new ArrayList();
				tempList.add(builder.toString());
				map.put(builder.length(), tempList);
			} else {
				map.get(builder.length()).add(builder.toString());
			}
			builder.setLength(0);
		}

		for (Integer key : map.keySet()) {
			System.out.println(key);
			String temp[] = new String[map.get(key).size()];
			for (int i = 0; i < map.get(key).size(); i++) {
				temp[i] = map.get(key).get(i);
			}
			Arrays.sort(temp);
			for (int j = 0; j < temp.length; j++) {
				if (j > 0 && temp[j - 1].equals(temp[j])) {
					continue;
				}
				bw.write(temp[j] + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}