package 백준_브론즈2;

import java.io.*;
import java.util.StringTokenizer;

/*
단어 - 공백으로 구별

예외처리
1. 공백으로 시작할 경우 ok
2. 공백으로 끝날 경우 ok
3. 공백만 있고 단어가 없을 경우 ok
 */

public class main_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = 0;

        while(st.hasMoreTokens()){
            st.nextToken();
            n+=1;
        }

        /*
        다른방법 : 내장 함수 중, countTokens() 사용
        bw.write(st.countTokens() + "\n");
         */

        bw.write(n + "\n");
        br.close();
        bw.flush();
        bw.close();

    }
}
