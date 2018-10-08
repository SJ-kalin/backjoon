package back.step_24.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2309 {

    static Stack<Integer> stack = new Stack();

    static int arr[] = new int[9];

    static int sum = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        combination(10, 7, 0);


    }

    private static void combination(int size, int count, int index) {

        if (sum == 100) {
            return;
        }

        if (size <= count) {
            return;
        } else if (count == 0) {
            showStack();
        } else {
            stack.push(arr[index]);
            combination(size - 1, count - 1, index + 1);

            stack.pop();
            combination(size - 1, count, index + 1);
        }

    }

    private static void showStack() {
        int tempArr[] = new int[stack.size()];
        sum = 0;
        for (int i = 0; i < stack.size(); i++) {
            sum = sum + stack.get(i);
        }

        if (sum == 100) {

            int stackArr[] = new int[stack.size()];
            for (int i = 0; i < stackArr.length; i++) {
                stackArr[i] = stack.get(i);
            }

            for (int i = 0; i < stackArr.length; i++) {
                for (int j = i; j < stackArr.length; j++) {
                    if (stackArr[i] > stackArr[j]) {
                        int temp = stackArr[j];
                        stackArr[j] = stackArr[i];
                        stackArr[i] = temp;
                    }
                }

            }


            for (int i = 0; i < stackArr.length; i++) {
                System.out.println(stackArr[i]);
            }

        }

    }


}
