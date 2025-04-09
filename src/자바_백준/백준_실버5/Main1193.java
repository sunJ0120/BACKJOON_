package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int n = 1;

        while(n*(n+1) < 2 * num){
            n++; //묶음
        }

        //이 묶음수에서 얼마를 빼주느냐가..생각하기 오래걸림
        int a = n - (n*(n+1)/2 - num); //정순
        int b = n+1-a; //역순

        if(n % 2 == 0){ //묶음이 짝수, 분모가 역순
            System.out.println(a + "/" + b);
        }else{
            System.out.println(b + "/" + a);
        }
    }
}
