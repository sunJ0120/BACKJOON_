package 백준_브론즈2;

import java.io.*;
import java.util.StringTokenizer;

public class main_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String str = st.nextToken();
        int n = Integer.parseInt(st.nextToken()); //진법
        int ans = 0; //답
        int digit = 0; //자릿수

        for (int i = str.length()-1; i >=0 ; i--) { //일의 자리수부터 계산.
            char c = str.charAt(i);
            int num;
            if (c >= '0' && c <= '9') { //십진수 까지의 숫자.
                num = c - '0';
            }else{
                num = c - 55; //A = 65
            }
            ans += Math.pow(n,digit) * num;
            digit++;
        }

        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
