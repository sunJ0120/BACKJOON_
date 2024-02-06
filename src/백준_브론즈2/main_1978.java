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
        boolean[] isPrime = new boolean[1000+1];
        Arrays.fill(isPrime,true); //전부 검사대상으로 변경

        isPrime[0] = false; //0과 1은 소수가 아니다.
        isPrime[1] = false;

        for(int i = 2; i*i <= 1000; i++){ //제곱근 까지만 검사하면 된다.
            if(isPrime[i]){ //소수의 배수를 전부 지워야 하므로 소수인지 판별한다.
                for(int j = i*i; j <= 1000; j+=i){ //i*i 이전은 i보다 작은 수의 배수이기 때문에 이미 검사가 끝난 이후이다.
                    isPrime[j] = false; //소수가 아니다로 변경
                }
            }
        }
        //----------------------

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(isPrime[a]){ //true라면 ans+1
                ans++;
            }
        }

        bw.write(ans + "\n");
        br.close();
        bw.flush();
        bw.close();

    }
}

