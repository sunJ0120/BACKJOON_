package 백준_브론즈3;

import java.io.*;
import java.util.StringTokenizer;

public class main_2884_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int hour = Integer.parseInt(st.nextToken());
        int minutes = Integer.parseInt(st.nextToken());

        //45분 보다 작으면 시간을 가져오는 방식으로 진행한다.
        //가져올 시간이 없는 0의 경우에만 24로 바꾸어 진행한다.

        if(minutes < 45){
            if(hour == 0){ //hour에서 1을 빌려오는 경우의 수는 45분보다 작을때 밖에 없으므로 24시로 바꾸는 것은 분이 45분보다 작을때만 시행하면 된다.
                hour = 24;
            }

            hour -= 1;
            minutes += 60;
        }

        minutes -= 45;

        bw.write(hour + " " + minutes + "\n");
        br.close();
        bw.flush();
        bw.close();

    }
}
