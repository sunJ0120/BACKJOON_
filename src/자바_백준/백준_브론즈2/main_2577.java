package 자바_백준.백준_브론즈2;

import java.io.*;

public class main_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int ans = a * b * c;
        int[] count = new int[10];

        char[] ch = (ans + "").toCharArray(); //int to string 알아두기

        for(int i = 0; i<ch.length; i++){
            count[ch[i] - '0']++; //char to int 알아두기
        }

        for(int i = 0; i<count.length; i++){
            bw.write(count[i] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
