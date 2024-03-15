package 자바_백준.백준_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

/*
A 순열을 내림차순 * B 순열을 오름차순
A 순열을 오름차순 * B 순열을 내림차순

두가지 결과를 비교한다.
 */
public class main_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st_a = new StringTokenizer(br.readLine());
        StringTokenizer st_b = new StringTokenizer(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];

        for(int i = 0; i<n; i++){
            a[i] = Integer.parseInt(st_a.nextToken());
            b[i] = Integer.parseInt(st_b.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int a_min = 0;
        int b_min= 0;

        int num = n-1;

        for(int w = 0; w<n;w++){
            a_min += a[w] * b[num]; //a오름차순, b내림차순
            b_min += b[w] * a[num]; //b오름차순, a내림차순
            num--;
        }

        System.out.println(min(a_min, b_min));
    }
}
