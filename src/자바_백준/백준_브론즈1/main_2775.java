package 자바_백준.백준_브론즈1;

import java.io.*;

public class main_2775 {
    static int[][] apart;

    public static int dp(int k, int n){
        if(k > 0 && n > 0 && apart[k][n] == 0){ //값이 없음
            apart[k][n] = dp(k-1, n) + dp(k, n-1);
        }

        return apart[k][n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine()); //test case

        apart = new int[15][15];

        //init
        for(int i = 1; i<15; i++){
            apart[0][i] = i;
        }

        for(int i = 0; i<num; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            bw.write(dp(k, n) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
