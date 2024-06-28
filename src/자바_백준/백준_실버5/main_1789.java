package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
자연수 S : (1 ≤ S ≤ 4,294,967,295) 이므로 unsigned long을 이용한다.
 */
public class main_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseUnsignedLong(br.readLine());
        long ans = 0;
        long num = 1;

        while((ans + num) <= s){
            ans += num;
            num++;
        }
        System.out.println(num-1); //커지는 순간 빠져 나오므로 num에서 커지는 순간인 1개 제거
    }
}
