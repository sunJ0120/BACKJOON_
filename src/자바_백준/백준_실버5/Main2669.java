package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2669 {
    static final int MAX_VALUE = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        StringTokenizer st;

        int[][] li = new int[MAX_VALUE][MAX_VALUE];

        //사각형 4개
        for(int z = 0; z<4; z++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int i = y1; i<y2;i++){ //1로 채우기
                for(int j = x1; j<x2; j++){
                    li[i][j] = 1;
                }
            }
        }

        for(int i = 0; i<MAX_VALUE;i++){ //1로 채우기
            for(int j = 0; j<MAX_VALUE; j++){
                if(li[i][j] == 1) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
