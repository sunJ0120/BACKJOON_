package 자바_백준.백준_브론즈1;

/*
피보나치수

기본적으로 피보나치수는 처음 수가 주어지고 재귀를 사용한다.
재귀를 사용하면 시간이 많이 걸리는 문제가 있긴 한데...일단 재귀를 사용해보자.
 */

import java.io.*;

public class main_2748 {
    public static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1];

        //-1로 배열 전부 초기화
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = 1;

        bw.write(fib(n) + "\n");
        bw.flush();
        br.close();
    }

    public static long fib(int n){
        if(dp[n] == -1){ //배열에 값이 없다면
            dp[n] = fib(n-1) + fib(n-2);
        }

        return dp[n];
    }
}
