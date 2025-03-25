package 자바_백준.백준_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();
        int n = Integer.parseInt(st);

        int num = st.length(); //자릿수

        int ans = 0;

        for(int i = 0; i<num-1; i++){
            ans += (9 * Math.pow(10,i)) * (i+1);
        }
        //자신의 자릿수
        ans += (n - Math.pow(10,num-1) + 1) * num;

        System.out.println(ans);
    }
}
