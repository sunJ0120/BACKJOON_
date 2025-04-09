package 자바_백준.백준_실버4;

import java.io.*;
import java.util.StringTokenizer;

public class Main2578 {
    static final int BINGO_N = 5;
    static int[][] bingo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bingo = new int[BINGO_N][BINGO_N];
        int[] voice = new int[BINGO_N * BINGO_N];

        //빙고 제작
        for(int i = 0; i<BINGO_N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<BINGO_N; j++){
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //사회자가 부르는 수
        for(int i = 0; i<BINGO_N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<BINGO_N; j++){
                voice[BINGO_N*i + j] = Integer.parseInt(st.nextToken());
            }
        }

        //빙고 맞추기
        for(int i = 0; i<voice.length; i++){
            checkBingo(voice[i]);
            if(i >= 11){ //최소 빙고 수 = 12
                if(isBingo()){
                    System.out.println(i+1); //몇번째 숫자인지.
                    break;
                }
            }
        }
    }

    public static void checkBingo(int num){ //빙고 체크하는 부분
        for(int i = 0; i<BINGO_N; i++){
            for(int j = 0; j<BINGO_N; j++){
                if(num == bingo[i][j]){
                    bingo[i][j] = 0;
                    return;
                }
            }
        }
    }
    public static boolean isBingo(){
        int cnt = 0;
        //행
        cnt += countBingoRow();
        //열
        cnt += countBingoColunm();
        //왼 -> 오른 대각선
        cnt += countBingoDia();

        return cnt >= 3 ? true : false;
    }

    public static int countBingoRow(){
        int ans = 0;
        for(int i = 0; i<BINGO_N; i++){
            boolean flag = true; //한줄씩
            for(int j = 0; j<BINGO_N; j++){
                if(bingo[i][j] != 0){ //그 줄은 검사할 필요 없음
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans++; //원빙고
            }
        }
        return ans;
    }

    public static int countBingoColunm(){
        int ans = 0;
        for(int i = 0; i<BINGO_N; i++){
            boolean flag = true; //한줄씩
            for(int j = 0; j<BINGO_N; j++){
                if(bingo[j][i] != 0){ //그 줄은 검사할 필요 없음
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans++; //원빙고
            }
        }
        return ans;
    }

    public static int countBingoDia(){
        int ans = 0;
        boolean flag = true; //한줄씩
        for(int i = 0; i<BINGO_N; i++){
            if(bingo[i][i] != 0){ //그 줄은 검사할 필요 없음
                flag = false;
                break;
            }
        }

        if(flag){
            ans++; //원빙고
        }

        //오른 -> 왼 대각선
        flag = true; //한줄씩
        for(int i = 0; i<BINGO_N; i++){
            if(bingo[i][(BINGO_N-1)-i] != 0){ //그 줄은 검사할 필요 없음
                flag = false;
                break;
            }
        }
        if(flag){
            ans++; //원빙고
        }
        return ans;
    }
}
