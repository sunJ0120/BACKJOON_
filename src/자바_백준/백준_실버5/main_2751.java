package 자바_백준.백준_실버5;

import java.io.*;

public class main_2751
{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        /*
        값이 -1,000,000 ~ 1,000,000이므로 1,000,000을 기준 인덱스로 두고, 값을 더하거나 빼서
        작은값 - 큰값으로 정렬되게끔 한다.

        직접 비교하는 것이 아니므로, 빠른 정렬이 가능하다.
        중복되는 값이 없기 때문에 가능하다.
         */
        boolean[] tlist = new boolean[2000000+1];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            tlist[num + 1000000] = true; //수를 저장
        }

        for (int i = 0; i <= 2000000; i++) {
            if(tlist[i]){
                bw.write((i-1000000) + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
