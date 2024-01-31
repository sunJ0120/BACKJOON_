package 백준_브론즈3;

import java.io.*;

/**
 * 원래 정배는, 자릿수를 구하고자 하는 문제이다.
 * 일의 자리 : B%10
 * 십의 자리 : (B/10) % 10
 * 백의 자리 : B/100;
 */

public class main_2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num1 = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int num2 = Integer.parseInt(str);

        for(int i = str.length()-1; i>=0; i--){ //거꾸로
            int j = str.charAt(i) - '0';
            bw.write((num1 * j) + "\n");
        }
        bw.write((num1 * num2) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
