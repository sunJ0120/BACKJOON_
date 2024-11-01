package 자바_백준.백준_실버2;

import java.io.*;
import java.util.StringTokenizer;

public class main_1012 {

    public static int[][] ll;
    public static boolean[][] bb;

    public static int[] goX = {-1,0,0,1};
    public static int[] goY = {0,-1,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        for(int g = 0; g<num; g++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken()); //가로 (x, i)
            int n = Integer.parseInt(st.nextToken()); //세로 (y, j)
            int k = Integer.parseInt(st.nextToken()); //위치 갯수

            int count = 0;

            ll = new int[n][m];
            bb = new boolean[n][m];

            //배추 위치 저장
            for(int j = 0; j<k; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                ll[n-1-y][x] = 1;
            }

            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    if(!bb[j][i] && ll[j][i] == 1){
                        count++;
                        dfs(i,j,m,n);
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int x, int y, int m, int n){
        bb[y][x] = true; //방문한 적 있다고 표식 남기기

        for(int i = 0; i < 4; i++){
            int x2 = x + goX[i];
            int y2 = y + goY[i];

            if(RangeCheck(x2, y2, m, n) && !bb[y2][x2] && ll[y2][x2] == 1){ //방문한 적이 없음
                dfs(x2, y2, m, n);
            }
        }
    }

    public static Boolean RangeCheck(int x, int y, int m, int n){
        return (x < m && x >= 0 && y < n && y >= 0);
    }
}
