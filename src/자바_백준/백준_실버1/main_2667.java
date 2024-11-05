package 자바_백준.백준_실버1;

import java.io.*;
import java.util.*;

public class main_2667 {
    static int[][] ll;
    static boolean[][] bl;
    static int[] goX = {-1,0,1,0};
    static int[] goY = {0,1,0,-1};

    static int count;

    static int num;
    static int number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());

        bl = new boolean[num][num];
        ll = new int[num][num];

        List<Integer> ans = new ArrayList<>();
        //리스트 저장
        for(int i = 0; i<num;i++){
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j< num; j++){
                ll[i][j] = ch[j] - '0';
            }
        }

        number = 0;
        for(int i = 0; i<num;i++) {
            for(int j = 0; j<num;j++) {
                if (!bl[i][j] && ll[i][j] == 1) {
                    count = 0;
                    dfs(i,j);
                    ans.add(count); //갯수 추가
                    number++;
                }
            }
        }

        Collections.sort(ans); //오름차순 정렬

        bw.write(number + "\n");
        for(int i = 0; i<ans.size();i++){
            bw.write(ans.get(i) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int i, int j){
        if(!bl[i][j]) {
            bl[i][j] = true;
            count++;

            for(int z = 0; z<4; z++){
                if(isIndexTrue(i, j, z) && ll[i + goY[z]][j + goX[z]] == 1){
                    dfs(i + goY[z], j + goX[z]);
                }
            }
        }
    }

    public static boolean isIndexTrue(int i, int j, int z){
        if(i + goY[z] < num && j + goX[z] < num && i + goY[z] >= 0 && j + goX[z] >= 0){
            return true;
        }
        return false;
    }
}
