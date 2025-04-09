package 자바_백준.백준_브론즈2;

import java.io.*;
import java.math.BigInteger;

public class main_1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();  // 8진수 입력 받기
        BigInteger n10 = new BigInteger(n, 8);  // 8진수를 10진수로 변환

        bw.write(n10.toString(2) + "\n");  // 2진수로 변환 후 출력
        bw.flush();
        br.close();
        bw.close();
    }
}

