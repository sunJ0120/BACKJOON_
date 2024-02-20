package 자바_백준.백준_실버5;

/*복습
1. dp를 이용해서 재귀 반복성 해결
2. 파스칼의 삼각형 이용해서 재귀 해결
3. n=r 이거나 r=0이면 return = 1
 */

import java.io.*;
import java.util.StringTokenizer;

public class main_1010 {
    public static int[][] dp = new int[30][30];

    public static int bridge(int n, int r){
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }

        if(dp[n][r] > 0){ //값이 있음
            return dp[n][r]; //재귀 없이 바로 리턴
        }

        return dp[n][r] = bridge(n-1,r-1) + bridge(n-1, r);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            bw.write(bridge(n, r) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}