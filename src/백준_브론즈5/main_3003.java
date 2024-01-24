package 백준_브론즈5;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 이미 순서가 정해져 있으므로 굳이 맵으로 만들 필요가 없을 것 같음. 리스트로 만든다.
 * 킹 = 0, 퀸 = 1, 룩 = 2, 비숍 = 3, 나이트 = 4, 폰 = 5
 */
public class main_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] chess = new int[6];
        int[] chessNum = {1,1,2,2,2,8};

        for(int i = 0; i < 6; i++){
            chess[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 6; i++){
            bw.write((chessNum[i] - chess[i]) + " ");
        }
        bw.write("\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
