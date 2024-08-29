package 자바_백준.백준_실버3;

import java.io.*;

public class main_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = num / 2; i >= 0; i --) {
            int a = 1; //분자
            int b = 1; //분모
            if(i != 0){
                int cntt = 0;
                int start = i + (num-(i*2));
                while(cntt != i){
                    a *= start;
                    a %= 15746;
                    start--;
                    cntt++;
                }

                for (int j = 1; j <= i; j++) {
                    b *= j;

                    b %= 15746;
                }
            }
            if(a != 0 && b != 0){
                cnt += a / b;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        br.close();
        bw.close();

    }
}
