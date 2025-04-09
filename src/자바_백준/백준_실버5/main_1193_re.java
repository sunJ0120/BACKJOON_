package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class main_1193_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int a;
        int b;

        int num = 1;

        while((num * (num+1)) < 2*n){ //특히 while문에서 이게 언제 멈추는지 알아야!
            num++;
        }


        if(num % 2 == 0){ //묶음이 짝수, 분자정순
            a = n - ((num * (num-1))/2);
            b = num+1 - a;
        }else{
            b = n - ((num * (num-1))/2);
            a = num+1 - b;
        }

        stb.append(a + "/" + b + "\n");

        System.out.println(stb);
        br.close();
    }
}
