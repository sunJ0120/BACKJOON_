package 백준_브론즈2;

import java.io.*;

/*
굳이 16진수 변환법을 알 필요 없이.
Integer.parseInt 를 사용하면 진법 변환이 가능하다.
내장함수를 살펴보자.
 */

public class main_1550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ans = Integer.parseInt(br.readLine(), 16);

        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
