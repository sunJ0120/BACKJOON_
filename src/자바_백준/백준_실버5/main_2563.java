package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
좌표 영역으로 보고, 영역에 해당하는 것들을 true로 바꿔주면 된다.
 */
public class main_2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] cord = new boolean[100+1][100+1];

        StringTokenizer st;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = y + 10; j > y; j--) {
                for (int z = x; z < x + 10; z++) {
                    if(!cord[j][z]){ //값이 없다면
                        cord[j][z] = true;
                        ans++; //넓이 하나 더하기
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
