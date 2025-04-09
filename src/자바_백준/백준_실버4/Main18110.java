package 자바_백준.백준_실버4;

import java.io.*;
import java.util.Arrays;

public class Main18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int ans = 0;

        int[] li = new int[num];

        for(int i = 0; i<num; i++){
            li[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(li); //정렬 필요

        int a = (int) Math.round((double) num * 0.15); //반올림

        for(int i = a; i<num-a; i++){
            ans += li[i];
        }

        ans = (int) Math.round((double)ans/(num-a*2));
        System.out.println(ans);
    }
}
