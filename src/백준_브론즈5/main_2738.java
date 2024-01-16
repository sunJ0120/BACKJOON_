package 백준_브론즈5;
import java.io.*;
import java.util.*;

/*
일반 배열로 이중 배열을 만든 다음에 리스트를 이용하는 방식으로 다시 풀어보자.
 */

public class main_2738 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //3 3
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //행렬 리스트
        //* 누적합을 사용할 필요가 없기 때문에 행렬을 하나만 만들어서 사용하면 된다.
        int[][] sumList = new int[N][M];

        //행렬1
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){ //1 1 1
                sumList[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //행렬2, 합
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){ //3 3 3
                sumList[i][j] += Integer.parseInt(st.nextToken());
            }
        }

        //더해서 내보내기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){ //3 3 3
                bw.write(sumList[i][j] + " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
