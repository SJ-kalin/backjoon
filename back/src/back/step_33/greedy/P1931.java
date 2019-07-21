package back.step_33.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1931 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<P1931node> list = new ArrayList<>();
        Queue<P1931node> q = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int starTime = Integer.parseInt(tokenizer.nextToken());
            int endTime = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).starTime == starTime && list.get(j).endTime < endTime) {
                    continue;
                }
            }
            P1931node p1931node = new P1931node(starTime, endTime);
            list.add(p1931node);
            q.add(p1931node);
        }

        int result = 0;
        while (!q.isEmpty()) {
            P1931node temp = q.poll();
            for (int i = 0; i < list.size(); i++) {
                if (temp.endTime <= list.get(i).starTime) {
                    int s = list.get(i).starTime;
                    int e = list.get(i).endTime;
                    P1931node node = new P1931node(s, e, temp.count + 1);
                    System.out.println(node.toString());
                    q.add(node);
                    result = count + 1;
                } else {
                    result = temp.count;
                }
            }
        }
        System.out.println(result + 1);


    }
}

class P1931node {


    int starTime;
    int endTime;
    int count;

    public P1931node(int starTime, int endTime) {
        this.starTime = starTime;
        this.endTime = endTime;
        this.count = 0;
    }

    public P1931node(int starTime, int endTime, int count) {
        this.starTime = starTime;
        this.endTime = endTime;
        this.count = count;
    }

    @Override
    public String toString() {
        return "P1931node{" +
                "starTime=" + starTime +
                ", endTime=" + endTime +
                ", count=" + count +
                '}';
    }
}
