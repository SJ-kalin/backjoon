package back.step_33.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2217 {

    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        num = count;
        int arr[] = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int max = arr[count - 1];
        while (canMultiply(max, arr)) {
            max = max + 1;
        }
        System.out.println(max);
    }

    private static boolean canMultiply(int max, int[] arr) {
        if (num == 0) {
            return false;
        }
        int pivot = (max / 2 == 0) ? max / num : max / num + 1;
        if (pivot <= arr[arr.length - num]) {
            return true;
        } else {
            num--;
            return canMultiply(max, arr);
        }
    }

}
