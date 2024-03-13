package 자바_백준.백준_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Brute Force
1. N-7 만큼의 이동이 가능하다.
2. 시작점 B or W 두가지를 나눈다.

** 64를 빼서 반대를 구한다는 것을 기억하자.
** 이 문제의 경우 생각의 틀을 정리해두기
*/

public class main_1018 {

    public static char[][] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        chess = new char[n][m];

        for(int i = 0; i<n; i++){
            chess[i] = br.readLine().toCharArray(); //이거 확인 필요
        }

        int awsMin = 64;

        for (int i = 0; i < n - 7; i++) { //갈수 있는 시작점들을 명시
            for (int j = 0; j < m - 7; j++) {
                awsMin = Math.min(awsMin, Math.min(find(i, j), 64 - find(i, j)));
            }
        }
        System.out.println(awsMin);
    }

    public static int find(int i, int j){
        int count = 0;
        int end_i = i+8;
        int end_j = j+8;

        char TF = chess[i][j]; //첫 항을 따온다.

        for(int z = i; z<end_i; z++){
            for(int l = j; l<end_j; l++){
                if(chess[z][l] != TF){ //첫항은 무조건 맞겠지만, 기준을 위해 잡는다.
                    count++;
                }
                if(TF == 'W'){
                    TF = 'B';
                }else{
                    TF = 'W';
                }
            }
            //한번더 바꾸기
            if(TF == 'W'){
                TF = 'B';
            }else{
                TF = 'W';
            }
        }
        return count;
    }
}
