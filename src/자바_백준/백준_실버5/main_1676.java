package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        while (n >= 5) {
            ans += n / 5; //5로 나눠지는 것의 개수, 25로 나눠지는 것의 개수, 125로/..이런식인가
            n /= 5;
        }

        System.out.println(ans);
    }
}
