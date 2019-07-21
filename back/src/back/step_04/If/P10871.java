package back.step_04.If;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P10871 {
    public static void main(String[] args) throws IOException {

//        Scanner scan = new Scanner(System.in);
//        int N = scan.nextInt();
//        int x = scan.nextInt();
//        int a[] = new int[N];
//        ArrayList<Integer> arrayList = new ArrayList<>();
//
//        for (int i = 0; i < N; i++) {
//            a[i] = scan.nextInt();
//        }
//
//        for (int i = 0; i < N; i++)
//            if (a[i] < x) {
//                arrayList.add(a[i]);
//            }
//
//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.print(arrayList.get(i) + " ");
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer inputToken = new StringTokenizer(br.readLine());

        int sizeOfArray = Integer.parseInt(inputToken.nextToken());
        int targetNumber = Integer.parseInt(inputToken.nextToken());
        int intArray[] = readNumbers(sizeOfArray);

        List<Integer> resultList = getLessNumber(targetNumber, intArray);

        printResult(resultList);
        br.close();
    }

    private static void printResult(List<Integer> list) {
        for (int currentIndex = 0; currentIndex < list.size(); currentIndex++) {
            System.out.println(list.get(currentIndex));
        }
    }

    private static List<Integer> getLessNumber(int targetNumber, int[] intArray) {
        List<Integer> tempList = new ArrayList<>();
        for (int currentIndex = 0; currentIndex < intArray.length; currentIndex++) {
            if (intArray[currentIndex] < targetNumber) {
                tempList.add(intArray[currentIndex]);
            }
        }
        return tempList;
    }

    private static int[] readNumbers(int sizeOfArray) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tempArr[] = new int[sizeOfArray];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());


        for (int currentIndex = 0; currentIndex < sizeOfArray; currentIndex++) {
            tempArr[currentIndex] = Integer.parseInt(tokenizer.nextToken());
        }

        br.close();
        return tempArr;
    }

}
