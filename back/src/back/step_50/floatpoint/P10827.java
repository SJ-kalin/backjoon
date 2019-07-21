package back.step_50.floatpoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class P10827 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        BigDecimal a = new BigDecimal(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());
        System.out.println(a.pow(b).toPlainString());
    }
}