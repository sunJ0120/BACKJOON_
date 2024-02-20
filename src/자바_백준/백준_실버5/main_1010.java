package 자바_백준.백준_실버5;

import java.io.*;
import java.util.StringTokenizer;

public class main_1010 {
    public static int[][] dp = new int[30][30];

    public static int bridge(int n, int r) {
        if (dp[n][r] > 0) { //값이 들어있다.
            return dp[n][r];
        }
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = bridge(n-1,r-1) + bridge(n-1,r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            bw.write(bridge(m, n) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
