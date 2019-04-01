package back.type_02.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeNum = Integer.parseInt(br.readLine());
        Boolean visited[] = new Boolean[nodeNum];
        int resultMatix[][] = new int[nodeNum][nodeNum];
        List<Integer>[] nodes = new List[nodeNum];
        for (int i = 0; i < nodeNum; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < tokens.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nodes[i] == null) {
                    nodes[i] = new ArrayList<>();
                }
                if (tokens[j].equals("1")) {
                    nodes[i].add(j);
                }
            }
        }

//        tostring()
//        for (int i = 0; i < nodes.length; i++) {
//            System.out.println(nodes[i].toString());
//        }

        for (int i = 0; i < nodeNum; i++) {
            Queue<Integer> queue = new LinkedList<>();
            if (nodes[i] == null) {
                continue;
            }
            Arrays.fill(visited, false);
            queue.add(i);
            while (!queue.isEmpty()) {
                int temp = queue.poll();
                if (nodes[temp] != null && !visited[temp]) {
                    for (int j = 0; j < nodes[temp].size(); j++) {
                        queue.add(nodes[temp].get(j));
                        resultMatix[i][nodes[temp].get(j)] = 1;
                    }
                }
                visited[temp] = true;
            }
        }
        for (int i = 0; i < resultMatix.length; i++) {
            for (int j = 0; j < resultMatix[i].length; j++) {
                System.out.print(resultMatix[i][j] + " ");
            }
            if (i != resultMatix.length - 1) System.out.println();
        }
    }
}
