package 자바_백준.백준_브론즈2;

import java.io.*;

public class main_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int n = 1; //겹수
        int sum = 1; //끝번호

        while(sum < num){
            sum += n*6;
            n++;
        }

        bw.write(n + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
