package 자바_백준.백준_실버3;

import java.io.*;

public class main_1904 {

    public static Integer[] fibo;

    public static int fibonachi(int num){
        if (fibo[num] == null) {
            fibo[num] = fibonachi(num-1) + fibonachi(num-2);
        }
        return fibo[num] % 15746;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        fibo = new Integer[num+1];

        fibo[0] = 1; //초기화
        fibo[1] = 1;

        bw.write( fibonachi(num) + "\n");
        bw.flush();
        br.close();
        bw.close();

    }
}
