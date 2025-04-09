package 자바_백준.백준_실버3;

import java.io.*;
import java.util.Arrays;


public class main_2579 {
    public static int[] dpList;
    public static int[] arr;
    public static int ans = 0;

    public static int dp(int num){
        if(dpList[num] == -1){ //저장되지 않은 값일 경우
            dpList[num] = Math.max(dp(num-3) + arr[num-1], dp(num-2)) + arr[num];
        }

        return dpList[num];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        arr = new int[num+1];
        dpList = new int[num+1];

        for (int i = 1; i <= num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dpList, -1);

        dpList[0] = arr[0]; //초기값, 배열 설정 주의!
        dpList[1] = arr[1];

        if(num >= 2){ //2보다 커서 2를 포함할 경우, 2를 미리 계산한다.
            dpList[2] = arr[1] + arr[2];
        }

        bw.write(dp(num) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
