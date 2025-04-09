package 자바_백준.백준_실버1;

import java.io.*;
import java.util.StringTokenizer;

public class main_1926 {

    static int[][] l;
    static boolean[][] bl;

    static int maxCount;
    static int currentCount;

    static int[] goX = {-1,0,1,0};
    static int[] goY = {0,1,0,-1};

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        l = new int[n][m];
        bl = new boolean[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                l[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int drawCount = 0;
        maxCount = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(l[i][j] == 1 && !bl[i][j]){
                    currentCount = 0;
                    drawCount++;
                    dfs(i,j);
                    maxCount = Math.max(maxCount,currentCount);
                }
            }
        }
        bw.write(drawCount + "\n");
        bw.write(maxCount + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int i, int j){
        currentCount++;
        bl[i][j] = true;
        for(int z = 0; z<4; z++) {
            if (isIndexTrue(i, j, z) && l[i + goY[z]][j + goX[z]] == 1 && !bl[i + goY[z]][j + goX[z]]) {
                dfs(i + goY[z], j + goX[z]);
            }
        }
    }

    public static boolean isIndexTrue(int i, int j, int z){
        if(i + goY[z] >= 0 && j + goX[z] >= 0 && i + goY[z] < n && j + goX[z] < m){
            return true;
        }
        return false;
    }
}
