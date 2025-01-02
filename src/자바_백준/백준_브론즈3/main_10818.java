package 자바_백준.백준_브론즈3;

import java.io.*;
import java.util.StringTokenizer;

public class main_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;

        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(st.nextToken());
            maxNum = Math.max(n,maxNum);
            minNum = Math.min(n,minNum);
        }

        bw.write(minNum + " " + maxNum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
