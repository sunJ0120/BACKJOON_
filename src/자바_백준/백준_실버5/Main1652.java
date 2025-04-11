package 자바_백준.백준_실버5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 1. 가로 따로 세로 따로 검사한다.
 * 두칸 이상 cnt 되면 전체 cnt를 하나 더하고 그 줄 검사를 close
 *
 * 출력형태 : "가로 세로"
 */
public class Main1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int roop = Integer.parseInt(br.readLine());
        char[][] ground = new char[roop][roop];
        for(int i = 0; i<roop; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            ground[i] = st.nextToken().toCharArray();
        }

        int row = 0; //가로 cnt
        int cul = 0; //세로 cnt

        //가로 검사
        row = cntRow(ground,roop);
        //세로 검사
        cul = cntCul(ground,roop);

        System.out.println(row + " " + cul);
    }
    //가로 검사
    public static int cntRow(char[][] ground, int num){
        int ans = 0;
        for(int i = 0; i<num; i++){
            int cnt = 0; //내부에서 몇개 이상인지 체크
            for(int j = 0; j<num; j++){
                if(ground[i][j] == '.'){ //입력 가능
                    cnt++;
                }else{
                    cnt = 0; //초기화
                }

                if(cnt == 2){
                    ans++;
                }
            }
        }
        return ans;
    }

    //세로 검사
    public static int cntCul(char[][] ground, int num){
        int ans = 0;
        for(int i = 0; i<num; i++){
            int cnt = 0; //내부에서 몇개 이상인지 체크
            for(int j = 0; j<num; j++){
                if(ground[j][i] == '.'){ //입력 가능
                    cnt++;
                }else{
                    cnt = 0; //초기화
                }

                if(cnt == 2){
                    ans++;
                }
            }
        }
        return ans;
    }
}
