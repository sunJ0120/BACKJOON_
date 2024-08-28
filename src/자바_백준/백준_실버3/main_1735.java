package 자바_백준.백준_실버3;

import java.io.*;
import java.util.StringTokenizer;

public class main_1735 {

    public static int GCD(int a, int b){ //최대공약수
        if(b == 0){
            return a;
        }
        return GCD(b, a%b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int gcd = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int b1 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());

        int a = (a1 * b2) + (b1 * a2);
        int b = a2 * b2;

        if(a>b){
            gcd = GCD(a, b);
        }else{
            gcd = GCD(b, a);
        }

        bw.write((a / gcd) + " ");
        bw.write((b / gcd) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
