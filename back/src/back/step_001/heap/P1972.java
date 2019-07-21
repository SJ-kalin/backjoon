package back.step_001.heap;

import javax.xml.soap.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class P1972 {

    // 1번 부터 시작하기 위해서
    static int heap[];
    static final int ROOT_INDEX = 1;
    static int currentIndex = 0;
    static int nextIndex = currentIndex + 1;

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        heap = new int[count];
        for (int i = 0; i < count; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                pop();
            } else {
                insert(input);
            }
//            System.out.println(Arrays.toString(heap) + "\t" + currentIndex + "\t" + heap[currentIndex]);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void pop() {
        if (heap[ROOT_INDEX] != 0) {
//            System.out.println(heap[ROOT_INDEX]);
            list.add(heap[ROOT_INDEX]);
            heap[ROOT_INDEX] = heap[currentIndex];
            heap[currentIndex] = 0;
            currentIndex = currentIndex - 1;
            nextIndex = currentIndex + 1;
//            System.out.println("hhhhhhh" + Arrays.toString(heap));
            topDownSort(ROOT_INDEX);
        } else {
            list.add(0);
//            System.out.println(0);
        }
    }

    private static void topDownSort(int rootIndex) {

        int leftChild = rootIndex * 2;
        int rightChild = leftChild + 1;

        if (leftChild > currentIndex) {
            return;
        } else if (leftChild == currentIndex) {
//            System.out.println("///////");
            if (heap[rootIndex] > heap[leftChild]) {
                int temp = heap[rootIndex];
                heap[rootIndex] = heap[leftChild];
                heap[leftChild] = temp;
            }
        } else {
//            System.out.println("--------");
//            System.out.println(Arrays.toString(heap));
            int min;
            if (heap[leftChild] < heap[rightChild]) {
                min = leftChild;
            } else {
                min = rightChild;
            }
            int temp = heap[rootIndex];
            heap[rootIndex] = heap[min];
            heap[min] = temp;
            topDownSort(min);
        }

    }


    private static void insert(int input) {
        heap[nextIndex] = input;
        currentIndex = nextIndex;
        nextIndex = nextIndex + 1;
        bottomUpSort();
    }

    private static void bottomUpSort() {
        int parentIndex = currentIndex / 2;
        int localCurrent = currentIndex;
        while (parentIndex > 0) {
            if (heap[localCurrent] < heap[parentIndex]) {
                int temp = heap[parentIndex];
                heap[parentIndex] = heap[localCurrent];
                heap[localCurrent] = temp;
            }
            localCurrent = parentIndex;
            parentIndex = parentIndex / 2;
        }
    }
}
