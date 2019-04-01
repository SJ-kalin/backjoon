package back.type_00.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1100 {
    public static void main(String[] args) throws IOException {
        Chess[][] chess = new Chess[8][8];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean type = false;
        for (int i = 0; i < chess.length; i++) {
            String temp = br.readLine();

            type = (i % 2 == 0) ? true : false;
            for (int j = 0; j < chess.length; j++) {
                chess[i][j] = new Chess(i, j, temp.substring(j, j + 1), type);
                type = !type;
            }
        }

        int count = 0;
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j].type && chess[i][j].v.equals("F")) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

class Chess {
    int x;
    int y;
    String v;
    boolean type;

    //  white => true, black => false
    Chess(int x, int y, String v, boolean type) {
        this.x = x;
        this.y = y;
        this.v = v;
        this.type = type;
    }
}
