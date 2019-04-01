package back.step_23.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1167 {

    static int[] distance;
    static LinkedList<NodeP1167> tree[];
    static Boolean visited[];
    static int heightValue[];
    static NodeP1167 maxDistanceNode;
    static int maxDistance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        tree = new LinkedList[count];
        distance = new int[count];
        visited = new Boolean[count];
        heightValue = new int[count];

        Arrays.fill(visited, false);
        for (int i = 0; i < count; i++) tree[i] = new LinkedList<NodeP1167>();

        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            String element[] = line.split(" ");
            for (int j = 1; j < element.length - 1; j = j + 2) {
                int parent = Integer.parseInt(element[0]) - 1;
                int child = Integer.parseInt(element[j]) - 1;
                int dist = Integer.parseInt(element[j + 1]);
                tree[parent].add(new NodeP1167(child, dist));
                tree[child].add(new NodeP1167(parent, dist));
            }
        }

        dfs(tree[0].get(1), 0);
        Arrays.fill(visited, false);
        dfs(maxDistanceNode, 0);
        System.out.println(maxDistance);
    }

    private static void dfs(NodeP1167 node, int distance) {
        visited[node.point] = true;

        for (NodeP1167 nodeP1167 : tree[node.point]) {
            if (!visited[nodeP1167.point]) {
                visited[nodeP1167.point] = true;
                dfs(nodeP1167, distance + nodeP1167.value);
            }
        }
        if (distance > maxDistance) {
            maxDistance = distance;
            maxDistanceNode = node;
        }
    }

}

class NodeP1167 {
    int point;
    int value;

    public NodeP1167(int point, int value) {
        this.point = point;
        this.value = value;
    }
}
