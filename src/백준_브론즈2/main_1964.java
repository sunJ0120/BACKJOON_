package 백준_브론즈2;

import java.io.*;

/*
우선, 오각형이 늘어날때 특징을 알아야 한다.
0단계 : 1 **등차수열의 공식 3n+1
1단계 : 1 + 4
2단계 : 1 + 4 + 7
3단계 : 1 + 4 + 7 + 10
4단계 : 1 + 4 + 7 + 10 + 13

수가 너무 커질 수 있고, 나머지를 출력하는 것이므로
각 더하는 수들은 전부 45678로 나눈 나머지로 치환

**왜인지 모르겠지만, 등차수열의 합 공식을 이용하면 틀렸다고 나오므로 정석대로 반복문을 이용하자.
 */

public class main_1964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        long sum = 1;

        for(int i = 1; i <= n; i++){
            sum += (i*3 + 1);
            sum %= 45678;
        }

        bw.write(sum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
