package back.step_14.fibonacci;

import java.util.Scanner;

public class P2749 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int result = pisano(scan.nextInt());
        System.out.println(result);
    }

    private static int pisano(int mod) {
        int fn1 = 1;
        int fn2 = 1;
        int fn = fn1 + fn2;
        int count = 2;
        if (mod == 1 || mod == 0) {
            return mod;
        }

        do {
            fn = fn1 + fn2;
            fn = fn % mod;
            fn1 = fn2;
            fn2 = fn;
            count++;
        } while (fn != 1 || fn2 != 1);

        return count;
    }

}
