package 자바_백준.백준_브론즈1;

import java.io.*;
import java.util.StringTokenizer;

public class main_11050 {
    static int[][] c;

    public static int dp(int n, int k){
        if(n > 0 && c[n][k] == 0){ //값이 없음
            c[n][k] = dp(n-1, k) + dp(n-1, k-1);
        }

        return c[n][k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        c = new int[n+1][n+1];

        //init
        //초기화 조건 주의
        for(int i = 1; i<=n; i++){
            c[i][0] = 1;
            c[i][i] = 1;
        }

        if(n >= 2){
            c[2][1] = 2;
        }

        bw.write(dp(n, k) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
