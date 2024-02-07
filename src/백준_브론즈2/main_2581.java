package 백준_브론즈2;

import java.io.*;
import java.util.Arrays;

/*
소수 문제이고, 수가 크므로 에라토스테네스의 체 알고리즘을 사용해서 해결한다.
최대수가 10000이므로, 10000+1의 배열을 만들어 진행한다.
 */
public class main_2581 {
    public static void main(String[] args) throws IOException {
        /*
        에라토스테네스의 체 알고리즘
         */
        //--------------------
        boolean[] isPrime = new boolean[10000 + 1];
        Arrays.fill(isPrime, true); //전부 검사대상으로

        isPrime[0] = false; //0과 1은 소수가 아니다.
        isPrime[1] = false;

        for(int i = 2; i*i <= 10000; i++){
            if(isPrime[i]){ //소수라면
                for (int j = i * i; j <= 10000; j += i) { //i의 배수를 지워줌
                    isPrime[j] = false;
                }
            }
        }
        //--------------------

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = -1;

        for(int i = start; i<=end; i++){
            if(isPrime[i] == true){ //소수라면
                if(min == -1){ //아직 초기값
                    min = i;
                }
                sum += i;
            }
        }

        if(sum == 0){ //소수가 없다.
            bw.write(min + "\n");
        }else{
            bw.write(sum + "\n");
            bw.write(min + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
