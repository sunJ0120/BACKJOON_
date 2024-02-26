package 자바_백준.백준_실버5;

import java.io.*;

public class main_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num = 1; //어느 구역에 n이 속하는지를 알기 위한

        while(((num*(num-1))/2) < n){
            num++;
        }
        num--;
        int ind = n - ((num*(num-1))/2); //어디인지 알기 위함

        if(num % 2 == 0){ //짝수 번째
            bw.write(ind + "/" + ((num+1)-ind) + "\n");
        }else{
            bw.write(((num+1)-ind) + "/" + ind + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
