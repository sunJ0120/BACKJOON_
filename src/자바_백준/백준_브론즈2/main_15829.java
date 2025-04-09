package 자바_백준.백준_브론즈2;

import java.io.*;

public class main_15829 {
    static long M = 1234567891;
    static long R = 31;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] ch = br.readLine().toCharArray();

        long ans = 0;

        for(int i = 0; i<n; i++){
            ans += ((ch[i] - 'a' + 1) * R_pow(i) % M);
            ans %= M;
        }

        bw.write(ans + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
    public static long R_pow(int n){
        long num = 1;
        for(int i = 0; i<n; i++){
            num *= R;
            num %= M;
        }
        return num;
    }
}
