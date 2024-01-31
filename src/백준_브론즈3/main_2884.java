package 백준_브론즈3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 요지는 결국 설정 시간보다 45분 빨라야 하는 것으로, 해당되는 시간을 분으로 변경해서 빨리 돌리면 된다.
 * 2. 중요한건 특이 케이스를 잘 처리하는 것일듯 싶다.
 * 1) 0시 0분 - 이럴 경우 어떻게 치환할지에 대해서
 *  0시를 24시간 단위로 바꿔서 계산하면 될듯 싶기도
 */

public class main_2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int hour = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());
        int total = 0;

        if(hour == 0){
            hour = 24;
        }

        hour *= 60; //분으로 변환
        total += hour;
        total += minutes;
        total -= 45; //45분 제거

        hour = (total/60); //시간은 몫
        minutes = (total%60); //분은 나머지

        if(hour == 24){ //24시 일 경우 0으로 변경
            hour = 0;
        }

        bw.write(hour + " " + minutes + "\n");
        br.close();
        bw.flush();
        bw.close();

    }
}
