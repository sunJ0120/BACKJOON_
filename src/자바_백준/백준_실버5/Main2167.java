package 자바_백준.백준_실버5;

import java.io.*;
import java.util.StringTokenizer;

public class Main2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] li = new int[m+1][n+1];

        //초기화
        for(int i = 0; i<=m; i++){
            li[i][0] = 0;
        }

        for(int i = 0; i<=n; i++){
            li[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                li[i][j] = li[i - 1][j] + li[i][j - 1] - li[i - 1][j - 1] + num;
            }
        }

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++ ) { //여기에 Integer.parseInt(br.readLine()); 이걸 바로 넣으면 안 된다. 반복문을 계속 검사하기 때문에
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int j1 = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            bw.write(li[x][y]-li[x][j1-1]-li[i1-1][y] + li[i1-1][j1-1] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
