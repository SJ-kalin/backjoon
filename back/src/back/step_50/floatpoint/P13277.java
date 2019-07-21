package back.step_50.floatpoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P13277 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        BigDecimal a = new BigDecimal(tokenizer.nextToken());
        BigDecimal b = new BigDecimal(tokenizer.nextToken());
        System.out.println(a.multiply(b).toPlainString());
    }
}
