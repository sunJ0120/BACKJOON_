package 자바_백준.백준_실버4;

import java.io.*;

public class main_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        if (num == 4 || num == 7) {
            bw.write(-1 + "\n");
        }else if((num%5) == 0){
            bw.write((num / 5) + "\n");
        }else if((num%5) == 3 || (num%5) == 1){
            bw.write(((num / 5) + 1) + "\n");
        }else{
            bw.write(((num / 5) + 2) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
