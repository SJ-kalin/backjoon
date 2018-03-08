package back.step_10.prime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class P9020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int count = Integer.parseInt(br.readLine());

		for (int i = 0; i < count; i++) {
			int evenNum = Integer.parseInt(br.readLine());
			ArrayList<Integer> primeArr = findPrime(evenNum);
			Node node = new Node();
			node = findNode(primeArr, evenNum);
			bw.write(String.valueOf(node.firstNum + " " + node.secondNum + "\n"));
		}
		bw.flush();
		bw.close();
		br.close();

	}

	private static Node findNode(ArrayList<Integer> primeArr, int evenNum) {

		ArrayList<Node> templist = new ArrayList();
		int index = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < primeArr.size(); i++) {
			for (int j = i; j < primeArr.size(); j++) {
				if ((primeArr.get(i) + primeArr.get(j)) == evenNum) {
					Node node = new Node(primeArr.get(i), primeArr.get(j));
					templist.add(node);
				}
			}
		}
		for (int i = 0; i < templist.size(); i++) {
			if (templist.get(i).sub < min) {
				min = templist.get(i).sub;
				index = i;
			}
		}
		return templist.get(index);
	}

	private static ArrayList<Integer> findPrime(int evenNum) {
		Boolean primeArr[] = new Boolean[evenNum + 1];
		ArrayList<Integer> list = new ArrayList();

		for (int i = 2; i < primeArr.length; i++) {
			primeArr[i] = true;
		}
		primeArr[0] = false;
		primeArr[1] = false;
		for (int i = 2; i < evenNum; i++) {
			if (primeArr[i]) {
				for (int j = 2;; j++) {
					if (i * j > evenNum) {
						break;
					} else {
						primeArr[i * j] = false;
					}
				}
			}
		}
		for (int i = 2; i < evenNum; i++) {
			if (primeArr[i]) {
				list.add(i);
			}
		}
		return list;
	}
}

class Node {
	int firstNum;
	int secondNum;
	int sub;

	public Node(int firstNum, int secondNum) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
		setSub();
	}

	public Node() {
	}

	private void setSub() {
		this.sub = (int) Math.abs(this.firstNum - this.secondNum);
	}
}