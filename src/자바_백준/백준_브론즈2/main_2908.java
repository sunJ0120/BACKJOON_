package 자바_백준.백준_브론즈2;

import java.io.*;
import java.util.StringTokenizer;

public class main_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[2];

        num[0] = Integer.parseInt(st.nextToken());
        num[1] = Integer.parseInt(st.nextToken());

        for(int i = 0; i<2; i++){
            int one = num[i] % 10;
            int ten = (num[i] / 10) % 10;
            int hun = (num[i] / 10) / 10;

            num[i] =  one * 100 + ten * 10 + hun;
        }

        bw.write(Math.max(num[0],num[1]) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
