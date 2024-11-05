package 자바_백준.백준_실버1;

import java.io.*;
import java.util.StringTokenizer;

public class main_2468 {

    static int[][] ll;
    static boolean[][] l;

    static int[] goX = {-1,0,1,0};
    static int[] goY = {0,1,0,-1};

    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        ll = new int[num][num];
        l = new boolean[num][num];

        int maxNum = 0;

        for(int i = 0; i<num;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<num;j++){
                int n = Integer.parseInt(st.nextToken());
                if(n > maxNum){
                    maxNum = n;
                }
                ll[i][j] = n;
            }
        }

        int maxCount = 1;
        int ind = 1; //침수 높이

        while(ind < maxNum){
            int currentCount = 0;
            //침수
            for(int i = 0; i<num;i++){
                for(int j = 0; j<num;j++){
                    ll[i][j] -= 1;
                }
            }

            for(int i = 0; i<num;i++){
                for(int j = 0; j<num;j++){
                    if(!l[i][j] && ll[i][j] > 0){
                        currentCount++;
                        dfs(i,j);
                    }
                }
            }

            maxCount = Math.max(currentCount,maxCount);

            //true, false 초기화
            for(int i = 0; i<num;i++){
                for(int j = 0; j<num;j++){
                    l[i][j] = false;
                }
            }
            ind++;
        }

        bw.write(maxCount + "\n");
        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int i, int j){
        if(!l[i][j]){
            l[i][j] = true;
            for(int z = 0; z<4; z++){
                if(isIndexTrue(i,j,z) && ll[i + goY[z]][j + goX[z]] > 0){
                    dfs(i + goY[z], j + goX[z]);
                }
            }
        }
    }

    public static boolean isIndexTrue(int i, int j, int z){
        if( i + goY[z] >= 0 && j + goX[z] >= 0 && i + goY[z] < num && j + goX[z] < num){
            return true;
        }
        return false;
    }
}
