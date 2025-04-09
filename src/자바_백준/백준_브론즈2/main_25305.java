package 자바_백준.백준_브론즈2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main_25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] li = new int[n];

        st = new StringTokenizer(br.readLine());

        int i = 0;
        while(st.countTokens() > 0){ //test
            li[i++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(li);
        bw.write(li[n-k] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
