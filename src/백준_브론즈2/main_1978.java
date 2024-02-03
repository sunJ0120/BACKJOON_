package 백준_브론즈2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
소수판별 알고리즘 = 에라토스테네스의 체를 이용하면 된다.
n배열을 만들어서
제곱근으로 이동하면서 2의배수..3의배수를 차례로 지워준다.
그 다음에 주어진 수들을 읽어와서 소수인지 아닌지 판별하면 된다.
 */
public class main_1978 {
    public static void main(String[] args) throws IOException {
        //----------------------
        /*
        에라토스테네스의 체 알고리즘
         */
        boolean[] isPrime = new boolean[1000+1]; //소수 판별 배열 설정
        Arrays.fill(isPrime, true); //초기값을 true로 설정

        isPrime[0] = false; //0과 1은 소수가 아니므로
        isPrime[1] = false;

        for (int i = 2; i * i <= 1000; i++) { //제곱근 까지 가는거고
            if (isPrime[i]) {
                for (int j = i*i; j <= 1000; j += i) { //j = i*i 이거인 이유가 3*n 이런 자신보다 작은수가 곱해져 있는 것은 이미 계산이 되었기 때문이다.
                    isPrime[j] = false;
                }
            }
        }
        //----------------------

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans = 0;

        for (int i = 0; i < size; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(isPrime[a] == true){
                ans += 1;
            }
        }
        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
