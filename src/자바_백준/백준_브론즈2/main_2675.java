package 자바_백준.백준_브론즈2;

import java.io.*;
import java.util.StringTokenizer;

public class main_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char[] ch = st.nextToken().toCharArray();

            for(char c : ch){
                for(int z = 0; z<n; z++){
                    bw.write(c);
                }
            }
            bw.write("\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
