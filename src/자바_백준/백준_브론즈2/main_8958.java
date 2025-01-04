package 자바_백준.백준_브론즈2;

import java.io.*;

public class main_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i<num; i++){
            char[] ch = br.readLine().toCharArray();
            int count = 0;
            int ans = 0;
            for(int j = 0; j<ch.length; j++) {
                if(ch[j] == 'O'){
                    count++;
                    ans += count;
                }else{
                    count = 0;
                }
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
