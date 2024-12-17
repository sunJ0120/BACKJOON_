package 자바_백준.백준_브론즈2;

import java.io.*;
import java.util.StringTokenizer;

public class main_1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ans = 1;
            for(int j = 0; j<b; j++){
                ans *= a;
                ans %= 10;
            }
            bw.write((ans == 0 ? 10 : ans) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
