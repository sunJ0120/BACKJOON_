package 자바_백준.백준_실버3;

import java.io.*;
import java.util.StringTokenizer;

public class main_1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int roop = Integer.parseInt(br.readLine());

        for (int i = 0; i < roop; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cnt = 0;

            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());

            int finish_x = Integer.parseInt(st.nextToken());
            int finish_y = Integer.parseInt(st.nextToken());

            int space = Integer.parseInt(br.readLine());

            for (int j = 0; j < space; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                double start_dis = Math.pow((Math.pow(x-start_x,2) + Math.pow(y-start_y,2)),0.5);
                double end_dis = Math.pow((Math.pow(x-finish_x,2) + Math.pow(y-finish_y,2)),0.5);

                if(start_dis <= r){ //내부
                    if(end_dis > r){ //같은 원 내부가 아님
                        cnt++;
                    }
                }else{ //외부
                    if(end_dis <= r){ //이 원이 내부일 경우
                        cnt++;
                    }
                }
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
