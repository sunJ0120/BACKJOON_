package 자바_백준.백준_브론즈2;

import java.io.*;

public class main_17608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int ans = 1;

        int[] li = new int[num];

        for(int i = 0; i<num; i++){
            li[i] = Integer.parseInt(br.readLine());
        }

        int max = li[num-1];

        for(int i = num-2; i>=0; i--) {
            if(max < li[i]){
                ans++;
                max = li[i];
            }
        }
        bw.write(ans+"\n");
        bw.flush();
        br.close();
        br.close();
    }
}
