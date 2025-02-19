package 자바_백준.백준_브론즈1;

import java.io.*;
import java.util.StringTokenizer;

public class main_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken()); //진법

        char[] a = new char[]
                {
                '0','1','2','3','4','5','6','7','8','9',
                'A','B','C','D','E','F','G',
                'H','I','J','K','L','M','N','O','P',
                'Q','R','S','T','U','V','W','X','Y','Z',
                };
        while(n > 0){
            stb.append(a[n%b]);
            n /= b;
        }
        System.out.println(stb.reverse());
    }
}
