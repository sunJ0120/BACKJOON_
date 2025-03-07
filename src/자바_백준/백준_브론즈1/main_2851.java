package 자바_백준.백준_브론즈1;

import java.io.*;

public class main_2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] li = new int[10];
        int a = 0;
        int b = 0;

        for(int i = 0; i<10; i++){
            li[i] = Integer.parseInt(br.readLine());
        }

        int i = 0;

        while(i < 10 && b < 100){
            a = b;
            b += li[i++];
        }

        if(100-a >= b-100){
            bw.write(b + "\n");
        }else{
            bw.write(a + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
