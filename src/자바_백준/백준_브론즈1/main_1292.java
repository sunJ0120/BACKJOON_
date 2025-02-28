package 자바_백준.백준_브론즈1;

import java.io.*;
import java.util.StringTokenizer;

public class main_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] li = new int[1001];

        //누적합
        int cnt = 0;
        int num = 1;

        for(int i = 1; i<=1000; i++){
            li[i] = li[i-1] + num;
            cnt++;

            if(cnt == num){
                cnt = 0;
                num++;
            }
        }

        bw.write(li[b] - li[a-1] + "\n"); //li[a-1]을 해야 a를 포함한다!
        bw.flush();
        bw.close();
        br.close();
    }
}
