package 자바_백준.백준_실버2;

import java.io.*;
import java.util.StringTokenizer;

public class main_4963 {

    static int x;
    static int y;

    static int[][] island;
    static boolean[][] flag;

    static int[] goX = {-1,0,1,0,-1,-1,1,1};
    static int[] goY = {0,1,0,-1,-1,1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if(x == 0 && y == 0){
                break;
            }

            //저장
            island = new int[y][x];
            flag = new boolean[y][x];

            int count = 0;

            for(int i = 0; i<y;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<x;j++){
                    island[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i<y;i++){
                for(int j = 0; j<x;j++){
                    if(island[i][j] == 1 && !flag[i][j]){
                        flag[i][j] = true;
                        count++;
                        dfs(i, j);
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int i, int j){
        for(int z = 0; z<8; z++){
            if(i + goY[z] < y && i + goY[z] >= 0 && j + goX[z] < x &&  j + goX[z] >= 0  && island[i + goY[z]][j + goX[z]] == 1 && !flag[i + goY[z]][j + goX[z]]){
                flag[i + goY[z]][j + goX[z]] = true; //방문 표시
                dfs(i + goY[z],j + goX[z]);
            }
        }
    }
}
