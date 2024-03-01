package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
팩토리얼 = 재귀 문제로 알고 있다.
재귀 = dp로 해결한다.

팩토리얼 구현하고, 배열로 바꾼다음 뒤에서부터 0이 아닌걸 세면 된다.

*숫자 범위가 너무 커서 못구하겠음...

 */
public class main_1676 {
    public static int[] dp;

    public static int facto(int n){
        if(n == 1 || n == 0){ //1! = 1
            return dp[n] = 1;
        }

        if(dp[n] > 0){ //뭔가 있음
            return dp[n];
        }
        return dp[n] = facto(n-1) * n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        StringBuilder stb = new StringBuilder();

        facto(n);
        stb.append(dp[n]);
        boolean zero = false;
        int ans = 0;

        for(int i = stb.length()-1; i >= 0;i--){ //거꾸로계산
            if(stb.charAt(i) == '0'){ //처음 0인 숫자가 나왔을때,
                zero = true;
                ans++;
            }
            if(zero && stb.charAt(i) != '0'){ //0인 상태에서 0이 아닌 것이 나왔을때
                break;
            }
        }
        System.out.println(ans);
    }
}
