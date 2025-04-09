package 자바_백준.백준_브론즈2;

import java.io.*;

public class main_1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int ans = 0;

        int st = (int) Math.ceil(Math.sqrt(a));
        int end = (int) Math.floor(Math.sqrt(b));

        for(int i = st; i<= end; i++){
            ans += i*i;
        }

        if(ans != 0){ //값이 있음
            bw.write(ans + "\n");
            bw.write(st*st + "\n");
        }else{
            bw.write(-1 + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
