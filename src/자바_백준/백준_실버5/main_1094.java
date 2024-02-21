package 자바_백준.백준_실버5;

import java.io.*;

/*
기존에는 0을 기준으로 잡았다.
그럴 필요 없이, 주어진 막대 길이 자체를 기준으로 두고
그게 0이 될때까지 시행하면 된다.
 */

public class main_1094 {
    public static int oriStick = 64;
    public static int stick(int n){

        int count = 0;

        while(n > 0){
            if(oriStick > n){
                oriStick /= 2;
            }else{
                n -= oriStick;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(stick(n) + "\n");
        bw.flush();
        br.close();
        br.close();
    }
}
