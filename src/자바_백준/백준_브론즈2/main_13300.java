package 자바_백준.백준_브론즈2;

import java.io.*;
import java.util.StringTokenizer;

public class main_13300 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int ans = 0;

        int[] g = new int[7];
        int[] b = new int[7];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int gen = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            if(gen == 0){
                g[grade]++;
            }else{
                b[grade]++;
            }
        }

        for(int i = 1; i<g.length; i++){
            if(g[i] > 0){
                ans += ((g[i]-1)/k + 1);
            }

            if(b[i] > 0){
                ans += ((b[i]-1)/k + 1);
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
