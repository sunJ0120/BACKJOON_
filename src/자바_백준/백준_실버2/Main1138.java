package 자바_백준.백준_실버2;

import java.io.*;
import java.util.StringTokenizer;

public class Main1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine()); //roop
        int cm = 1;
        int[][] li = new int[num][2];
        int[][] ans = new int[num][2];

        //초기화
        for(int i = 0; i<num; i++){
            ans[i] = new int[]{num,0};
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<num; i++){
            li[i][0] = cm++;
            li[i][1] = Integer.parseInt(st.nextToken()); //왼쪽..
        }

        for(int i = 0; i<num; i++){
            int cnt = 0;
            for(int j = 0; j<num; j++){
                if(ans[j][0] >= li[i][0]){ //ans는 j로 이동한다!
                    if(li[i][1] == cnt){
                        ans[j] = li[i];
                        break;
                    }
                    cnt++;
                }
            }
        }

        for(int i = 0; i<num; i++){
            bw.write(ans[i][0] + " ");
        }
        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
