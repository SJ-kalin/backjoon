package back.step_29.binarysearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int arr[] = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(arr);

        count = Integer.parseInt(br.readLine());
        tokenizer = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            binarySearching(num, arr, arr.length / 2);
        }

    }

    private static void binarySearching(int num, int[] arr, int index) {


        if (index >= arr.length) {
            System.out.println(0);
            return;
        } else if (arr[index] == num) {
            System.out.println(1);
            return;
        } else if (index <= 0) {
            System.out.println(0);
            return;
        }
        if (arr[index] < num) {
            binarySearching(num, arr, (index + arr.length + 1) / 2);
        } else if (arr[index] > num) {
            binarySearching(num, arr, (arr.length % 2 == 0 ? index : index - 1) / 2);
        }


    }
}
