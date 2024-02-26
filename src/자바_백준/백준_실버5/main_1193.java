package 자바_백준.백준_실버5;

<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
사용할 변수
1. 이전 범위까지 대각선 누적합(prev_count_sum)
2. 해당 범위 대각선 칸의 개수(cross_count)
3. 입력 받을 n값

* 대각선 칸의 개수가 짝수인지, 홀수인지에 따라 다르게 구성한다.
 */
public class main_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int prev_count_sum = 0;
        int cross_count = 1;

        while(true){
            if(n <= cross_count + prev_count_sum){
                if((cross_count % 2) == 0){ //짝수
                    System.out.println((n - prev_count_sum) + "/" + ((cross_count +1) - (n - prev_count_sum)));
                    break;
                }else{ //홀수는 반대
                    System.out.println(((cross_count +1) - (n - prev_count_sum)) + "/" + (n - prev_count_sum));
                    break;
                }
            }else{
                prev_count_sum += cross_count;
                cross_count++;
            }
        }
=======
import java.io.*;

public class main_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num = 1; //어느 구역에 n이 속하는지를 알기 위한

        while(((num*(num-1))/2) < n){
            num++;
        }
        num--;
        int ind = n - ((num*(num-1))/2); //어디인지 알기 위함

        if(num % 2 == 0){ //짝수 번째
            bw.write(ind + "/" + ((num+1)-ind) + "\n");
        }else{
            bw.write(((num+1)-ind) + "/" + ind + "\n");
        }

        bw.flush();
        bw.close();
>>>>>>> try
        br.close();
    }
}
