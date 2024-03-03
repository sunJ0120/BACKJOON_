package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
어렵게 짤 필요 없이. 그냥 5의 배수의 갯수에 따라 달라진다는 점을 이용하면 된다.
 */
public class main_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int m;

        while(n >= 5){
            m = n;
            while(m % 5 == 0){ //5가 들어있는 수 구하기
                ans++;
                m /= 5;
            }
            n--;
        }
        System.out.println(ans);
    }
}
