package 자바_백준.백준_브론즈1;

import java.io.*;
import java.util.StringTokenizer;

/*
자바 1934번이랑 연결되는 문제이다.
gcd를 정의해서 최대공약수와 최소공배수를 정의해랴.
 */
public class main_2609{
    public static int gcd(int a, int b) {
        while(b != 0){
            int c = a%b;
            a = b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int mi = gcd(a, b);
        int ma = (a/mi) * (b/mi) * mi;

        br.close();
        bw.write(mi + "\n");
        bw.write(ma + "\n");
        bw.flush();
        bw.close();
    }
}
