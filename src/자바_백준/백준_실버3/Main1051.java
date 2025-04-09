package 자바_백준.백준_실버3;

import java.io.*;
import java.util.StringTokenizer;

public class Main1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] li = new int[a][b];

        for(int i = 0; i<a; i++){
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j<b; j++){
                li[i][j] = ch[j] - '0';
            }
        }

        int min = Math.min(a, b);

        for(int i = 1; i<min; i++){ //더해지는 기준수
            if(hasSquare(li,a,b,i)){
                max = i+1;
            }
        }
        System.out.println(max*max);
    }
    public static boolean hasSquare(int[][] li, int row, int cul, int size){
        for(int i = 0; i<row-size; i++){ //기준 열
            for(int j = 0; j<cul-size; j++){ //기줄 행
                int val = li[i][j];
                if(val == li[i][j+size] && val == li[i+size][j] && val == li[i+size][j+size]){
                    return true; //있음
                }
            }
        }
        return false; //이 사이즈 없음
    }
}
