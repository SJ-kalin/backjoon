package back.step_27.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2902 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String arr[] = word.split("-");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].charAt(0));
        }
    }

}
