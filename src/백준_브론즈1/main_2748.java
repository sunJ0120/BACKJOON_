package 백준_브론즈1;

/*
피보나치수

기본적으로 피보나치수는 처음 수가 주어지고 재귀를 사용한다.
재귀를 사용하면 시간이 많이 걸리는 문제가 있긴 한데...일단 재귀를 사용해보자.
 */

import java.io.*;

public class main_2748 {
    public static int num = 1;
    public static long pivot(long a, long b,int n){
        if(num == n){
            return b; //피보나치 수 리턴하기
        }
        num++;
        return pivot(b,a+b,n);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long ans;

        long a = 0;
        long b = 1;

        ans = pivot(a, b, n);

        bw.write(ans + "\n");
        bw.flush();
        br.close();
    }
}
