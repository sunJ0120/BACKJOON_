package 백준_브론즈1;

/*
A, B, V
n += A
n -= B 해서 v까지 언제 도착할지를 따지면 될 듯 싶다.
한 가지 궁금한 것은, 결국 while 문을 사용해야 할 것 같은데
V ≤ 1,000,000,000라서 시간이 오래 걸릴것 같은데 다른 방법이 있는지
 */

import java.io.*;
import java.util.StringTokenizer;

public class main_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num = 0;
        int ans = 1;

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        while((num += a) < v){ //먼저 올라가기
            num -= b;
            ans++;
        }
        bw.write(ans + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
