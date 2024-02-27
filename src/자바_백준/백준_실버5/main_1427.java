package 자바_백준.백준_실버5;

import java.io.*;

/*
카운팅 정렬을 이용해보자.
자릿수 구하기
1. 10으로 나눈 나머지를 계속 구한다.
2. 수를 10으로 나눈 몫으로 바꿔준다.
 */
public class main_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] num = new int[10];

        while(n > 0){
            num[n%10]++; //숫자가 존재한다면 +1이 된다.
            n /= 10;
        }

        for (int i = 9; i >= 0; i--) {
            while(num[i]-- > 0){ //숫자가 나온적이 있으면
                stb.append(i);
            }
        }
        stb.append("\n");
        System.out.println(stb);

        br.close();
    }
}
