package 자바_백준.백준_브론즈2;

import java.io.*;
import java.util.StringTokenizer;

public class main_2902{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        while(st.hasMoreTokens()){
            bw.write(st.nextToken().charAt(0) + "");
        }
        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
