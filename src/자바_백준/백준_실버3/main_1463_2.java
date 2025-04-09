package 자바_백준.백준_실버3;

import java.io.*;

public class main_1463_2 {
    static Integer[] dpList;

    public static int dp(int num){
        if(dpList[num] == null){ //dp이므로, null일때만 check하지 않으면 바로 stackOverflow 발생
            if (num % 6 == 0) {
                dpList[num] = Math.min(Math.min(dp(num/3), dp(num/2)), dp(num-1)) + 1;
            }else if(num % 3 == 0){
                dpList[num] = Math.min(dp(num/3), dp(num-1)) + 1;
            } else if (num % 2 == 0) {
                dpList[num] = Math.min(dp(num/2), dp(num-1)) + 1;
            }else{
                dpList[num] = dp(num-1) + 1; //경우의 수 하나 밖애 없음
            }
        }

        return dpList[num]; //그대로 return해주면 된다.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        dpList = new Integer[num+1];

        dpList[0] = 0; //초기값을 주지 않으면 에러가 나므로 항시 주의!!
        dpList[1] = 0;

        bw.write(dp(num) + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
