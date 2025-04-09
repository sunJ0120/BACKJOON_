package 자바_백준.백준_실버3;

import java.io.*;
import java.util.Arrays;

public class main_2193 {
    public static long[] dp;

    public static long echinsu(int n){
        if(dp[n] < 0){ //값이 들어 있지 않다.
            dp[n] =  echinsu(n-1) +  echinsu(n-2);
        }

        return dp[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        dp = new long[n+1];

        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 1;

        bw.write(echinsu(n) + "\n");
        bw.flush();
        br.close();
        bw.close();

    }
}
