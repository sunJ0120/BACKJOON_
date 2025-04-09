package 자바_백준.백준_실버4;

import java.io.*;
import java.util.Stack;

public class main_3986_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < num; i++) {
            String st = br.readLine();
            char[] ch = st.toCharArray();

            Stack<Character> sta = new Stack<>();

            for (int j = 0; j < ch.length; j++) {
                if(sta.empty()){
                    sta.push(ch[j]);
                }else{
                    if (ch[j] == sta.peek()) {
                        sta.pop();
                    }else{
                        sta.push(ch[j]);
                    }
                }
            }

            if(sta.empty()){
                cnt++;
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
