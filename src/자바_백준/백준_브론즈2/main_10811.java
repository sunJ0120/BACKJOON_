package 자바_백준.백준_브론즈2;

import java.io.*;
import java.util.StringTokenizer;

public class main_10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] n = new int[Integer.parseInt(st.nextToken())];
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1; i<=n.length;i++){
            n[i-1] = i;
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) -1;
            int ed = Integer.parseInt(st.nextToken()) -1;

            while(s < ed){
                int a = n[s];
                n[s] = n[ed];
                n[ed] = a;

                s++;
                ed--;
            }
        }

        for(int i = 0; i<n.length; i++){
            bw.write(n[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
