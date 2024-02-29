package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

/*
 * StringTokenizer를 이용한 방법도 있다.
 * token을 기준으로 나누는 것이므로 이를 이용하면 '0','1' 기준으로 나눌 수 있다.
 */

public class main_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer zero = new StringTokenizer(str, "0");
        StringTokenizer one = new StringTokenizer(str, "1");

        System.out.println(min(zero.countTokens(),one.countTokens()));
    }
}
