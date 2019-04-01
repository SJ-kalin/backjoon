package back.step_24.graph;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class P1325 {

    static int max = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int num = Integer.parseInt(tokenizer.nextToken());
        int count = Integer.parseInt(tokenizer.nextToken());

        List<Integer>[] computerList = new List[num];
        int[] resultList = new int[num];
        visited = new boolean[num];

        for (int i = 0; i < count; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;

            if (computerList[b] == null) {
                computerList[b] = new ArrayList<>();
            }
            computerList[b].add(a);
        }

//        for (int i = 0; i < computerList.length; i++) {
//            if (computerList[i] != null) {
//                System.out.println("i ==" + i + "\t" + computerList[i].toString());
//            }
//        }

        for (int i = 0; i < computerList.length; i++) {
            if (computerList[i] != null) {
                Arrays.fill(visited, false);
                int result = dfs(i, computerList);
                resultList[i] = result;
            }
        }
        for (int i = 0; i < resultList.length; i++) {
            if (resultList[i] == max) {
                bw.write(i + 1 + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static int dfs(int i, List<Integer>[] computerList) {
        Queue<Integer> queue = new LinkedList();
        queue.add(i);
        int count = 0;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            count++;
            if (computerList[n] != null && !visited[n]) {
                for (int k = 0; k < computerList[n].size(); k++) {
                    queue.add(computerList[n].get(k));
                }
                visited[n] = true;
            }

        }
        max = max < count ? count : max;
        return count;
    }
}