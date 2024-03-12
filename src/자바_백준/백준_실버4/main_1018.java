package 자바_백준.백준_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
중요한 것은, 앞에서 더한 것들을 빼주면서 진행하는게 중요할듯
이거 어떻게 해야할지 모르겠다... 답 찾아보기
 */
public class main_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] search = new boolean[n][m]; //굳이 이중배열을 만들어야 할까?
        char[][] chess = new char[n][m];

        for(int i = 0; i<n; i++){
            chess[i] = br.readLine().toCharArray(); //이거 확인 필요
        }

        /*
        search 과정
         */
        int start = 0;
        int end = 7;
        int bw = 0; //0 -> B, 1 -> W

        int i;
        int j;

        boolean bool = true;

        while(bool){
            for(i = start; i<end; i++){
                for(j = start; j<end; j++){
                    //start 조건
                    if(j == start){ //if문이 너무 많음..
                        if(chess[i][j] == 'W'){
                            bw = 1;
                        }

                        search[i][j] = true;
                    }

                    //검사
                    if(!search[i][j]){ //false
                        if(bw == 0){ //이전이 B
                            if(chess[i][j] == 'W'){
                                search[i][j] = true;
                            }
                            bw = 1;
                        }else{ //이전이 W
                            if(chess[i][j] == 'B'){
                                search[i][j] = true;
                            }
                            bw = 0;
                        }
                    }

                }
            }
        }


    }
}
