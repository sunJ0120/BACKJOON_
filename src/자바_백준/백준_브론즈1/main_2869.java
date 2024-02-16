package 자바_백준.백준_브론즈1;

/*
A, B, V
* 도착하고 나서는 떨어지지 않음
낮에 올라가는 만큼을 먼저 빼고, 하루를 더한다.
a-b 만큼 나눈 몫을 더한다.(그만큼 더 걸리는 것이기 때문이다.)
나머지가 존재할 경우, 한 번 더 올라가야 하는 것이므로 +1한다.
 */

import java.io.*;
import java.util.StringTokenizer;

public class main_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans = 1;

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        ans += (v - a) / (a - b);

        if((v - a) % (a - b) != 0){
            ans += 1;
        }

        bw.write(ans + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
