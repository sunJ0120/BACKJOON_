package 자바_백준.백준_실버2.복습;

import java.io.*;
import java.util.StringTokenizer;

public class main_1012 {
    static int[] goX = {-1,0,1,0};
    static int[] goY = {0,1,0,-1};

    static int[][] field;
    static boolean[][] cabbage;

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int z = 0; z<num;z++){
            st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int count = 0;

            field = new int[n][m];
            cabbage = new boolean[n][m];

            //숫자 저장
            for(int j = 0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = (n-1)-Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }

            //dfs
            for(int i = 0; i<n;i++){
                for(int j = 0; j<m;j++){
                    if(!cabbage[i][j] && field[i][j] == 1){
                        cabbage[i][j] = true;
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
        for(int z = 0; z<4;z++){
            if(isTrue(i+goY[z], j+goX[z])){
                cabbage[i+goY[z]][j+goX[z]] = true; //방문
                dfs(i+goY[z], j+goX[z]);
            }
        }
    }

    public static boolean isTrue(int i, int j){
        if(i >= 0 && j >= 0 && i < n && j < m && !cabbage[i][j] && field[i][j] == 1){ //범위 안에 있고, 해당하는지 체크, IndexOut 예방
            return true;
        }
        return false;
    }
}
