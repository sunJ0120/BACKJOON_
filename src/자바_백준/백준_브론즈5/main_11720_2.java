package 자바_백준.백준_브론즈5;

import java.io.*;

/*
20240127 풀이
마찬가지로 완벽하게 풀지는 못했으므로
다시 한 번 더 풀어야함
 */

public class main_11720_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        String str = br.readLine();
//        char[] charArray = br.readLine().toCharArray();
//
//        for (int i = 0; i < n; i++) {
//            ans += charArray[i] - '0';
//        }

        for (int i = 0; i < n; i++) {
            ans += str.charAt(i) - '0';
        }

        bw.write(ans + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
