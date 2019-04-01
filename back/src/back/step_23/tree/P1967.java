package back.step_23.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1967 {

    static LinkedList<LeafRelation>[] tree = new LinkedList[10000];
    static int maxDistance;
    static int maxDistanceNode;
    static boolean visited[] = new boolean[10000];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfRelation = Integer.parseInt(br.readLine());
        Arrays.fill(visited, false);

        while (--numberOfRelation > 0) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int parentNode = Integer.parseInt(tokenizer.nextToken()) - 1;
            int childNode = Integer.parseInt(tokenizer.nextToken()) - 1;
            int value = Integer.parseInt(tokenizer.nextToken());
            if (tree[parentNode] == null) {
                tree[parentNode] = new LinkedList<>();
            }

            if (tree[childNode] == null) {
                tree[childNode] = new LinkedList<>();
            }
            tree[parentNode].add(new LeafRelation(childNode, value));
            tree[childNode].add(new LeafRelation(parentNode, value));
        }

        dfs(0, 0);
        Arrays.fill(visited, false);
        maxDistance = 0;
        dfs(maxDistanceNode, 0);
        System.out.println(maxDistance);
    }

    private static void dfs(int rootNodeNum, int distance) {

        visited[rootNodeNum] = true;

        for (int i = 0; i < tree[rootNodeNum].size(); i++) {
            int childeNode = tree[rootNodeNum].get(i).point;
            if (!visited[childeNode]) {
                dfs(childeNode, distance + tree[rootNodeNum].get(i).value);
            }
        }

        if (maxDistance < distance) {
            maxDistance = distance;
            maxDistanceNode = rootNodeNum;
        }

    }
}

class LeafRelation {
    int point;
    int value;

    public LeafRelation(int point, int value) {
        this.value = value;
        this.point = point;
    }
}
