package 자바_백준.백준_브론즈2;

import java.io.*;

public class main_25501 {
    static int cnt;

    public static int isPell(int st, int end, char[] ch){
        cnt++;

        if(st >= end){ //무사히 종료조건
            return 1;
        }

        if(ch[st] == ch[end]){
            return isPell(st+1, end-1, ch);
        }else{
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i<num; i++){
            cnt = 0;
            char[] ch = br.readLine().toCharArray();
            bw.write(isPell(0, ch.length-1, ch) + " " + cnt + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
