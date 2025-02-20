package 자바_백준.백준_브론즈1;

import java.io.*;

public class main_1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] ans = br.readLine().toCharArray();

        for(int i = 0; i<n-1; i++){
            char[] a = br.readLine().toCharArray();
            for(int j = 0; j<a.length; j++){
                if(ans[j] != a[j]){
                    ans[j] = '?';
                }
            }
        }
        bw.write(new String(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
