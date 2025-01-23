package 자바_백준.백준_브론즈2;

import java.io.*;
import java.util.Arrays;

public class main_10807 {
    static int num;
    static int[] dp;

    public static int DP(int n){
        if(dp[n] < 0){ //값이 없을 경우
            dp[n] = DP(n-1) + DP(n-2); //저장
        }

        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        dp = new int[num+2];

        Arrays.fill(dp,-1);

        dp[0] = 0;
        dp[1] = 1;

        bw.write(DP(num) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
