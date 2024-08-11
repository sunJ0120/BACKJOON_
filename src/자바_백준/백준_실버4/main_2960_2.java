package 자바_백준.백준_실버4;

import java.io.*;
import java.util.StringTokenizer;

/*
N K
2부터 N까지 K가 언제 나오는지를 보라.
 */

public class main_2960_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int ans = 0;

        boolean[] check = new boolean[N+1];

        for (int i = 2; i <= N; i++) {

            if(ans != 0){
                break;  //이렇게 양쪽으로 잡아도 되는건가..
            }

            for (int j = 1; j * i <= N; j++) {
                if(!check[i*j]){
                    check[i*j] = true;
                    cnt++;
                }

                if(cnt == K){
                    ans = i*j;
                    break;
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
