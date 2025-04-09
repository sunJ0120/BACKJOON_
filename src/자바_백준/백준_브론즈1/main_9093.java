package 자바_백준.백준_브론즈1;

import java.io.*;
import java.util.StringTokenizer;

public class main_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int roop = Integer.parseInt(br.readLine());

        for(int i = 0; i<roop; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rp = st.countTokens();
            for(int j = 0; j < rp; j++){
                char[] ch = st.nextToken().toCharArray();
                int sta = 0;
                int end = ch.length-1;

                while(sta < end){
                    char a = ch[sta];
                    ch[sta] = ch[end];
                    ch[end] = a;

                    sta++;
                    end--;
                }
                bw.write(new String(ch) + " "); //char[] -> string
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
