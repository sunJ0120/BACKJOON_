package 자바_백준.백준_브론즈2;

import java.io.*;
import java.util.Arrays;

public class main_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nlist = new int[n];

        for (int i = 0; i < n; i++) {
            nlist[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nlist);

        for (int i = 0; i < n; i++) {
            bw.write(nlist[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }
}
