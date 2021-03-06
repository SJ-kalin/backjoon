package back.step_27.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P11478 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            int startIndex = 0;
            int lastIndex = i + 1;
            while (lastIndex != word.length() + 1) {
                String temp = word.substring(startIndex++, lastIndex++);
                if (!map.containsKey(temp)) {
                    map.put(temp, temp);
                }
            }
        }
        System.out.println(map.size());
    }
}
