package back.step_16.dynamicFirst;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2293 {

    static int sum;
    static int count;
    static List<Integer> coins;
    static Map<Integer, Integer> map;
    static Map<String, Boolean> visited;
    static int visit[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int coin = Integer.parseInt(token.nextToken());
        sum = Integer.parseInt(token.nextToken());
        coins = new ArrayList<>();
        map = new HashMap<>();
        visited = new HashMap<>();

        for (int i = 0; i < coin; i++) {
            coins.add(Integer.parseInt(br.readLine()));
            map.put(coins.get(i), 0);
        }


        dfs(0, -1);
        System.out.println(count);
    }

    private static void dfs(int result, int value) {

        if (value != -1) {
            map.put(value, map.get(value) + 1);
        }

        if (result == sum) {
            StringBuffer stringBuffer = new StringBuffer("");
            for (Integer key : map.keySet()) {
                stringBuffer.append(map.get(key));
            }
            if (!visited.containsKey(stringBuffer.toString())) {
                visited.put(stringBuffer.toString(), true);
                count++;
            }
            map.put(value, map.get(value) - 1);
            return;
        } else if (result > sum) {
            map.put(value, map.get(value) - 1);
            return;
        }

        for (int i = 0; i < coins.size(); i++) {
            dfs(result + coins.get(i), coins.get(i));
        }
        if (map.containsKey(value)) {
            map.put(value, map.get(value) - 1);
        }
    }


}
