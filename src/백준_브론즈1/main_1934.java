package 백준_브론즈1;

import java.io.*;
import java.util.StringTokenizer;

/*
최소 공배수 구하기
* 이거는 무조건 유클리드 호재법을 이용해야 한다. 집가서 정리하기
 */
public class main_1934 {

    /*
    이렇게 재귀 말고도,
    while 반복문을 이용해서 나머지가 0이 될 때까지 나눠주는 방법도 있다.
     */

    public static int gcd(int a, int b){
        if(b == 0){ //나머지가 0이 될 경우
            return a;
        }else{
            return gcd(b, a%b);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int minEqual;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            minEqual = gcd(a,b);

            bw.write((a/minEqual)*(b/minEqual)*minEqual + "\n");
            bw.flush();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
