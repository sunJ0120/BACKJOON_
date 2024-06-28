package 자바_백준.백준_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
Brute Force
1. 옆으로 n-7 만큼의 이동이 가능하다.
2. 아래로 n-7 만큼의 이동이 가능하다.
3. 내부에서도 8번의 이동이 필요하다.
4. 내부에서의 로직은 for문이 다시 들어가야 하기 때문에 따로 method로 뺀다.
5. 앞이 b인경우, w인 경우를 나눠야 하기 때문에, 이의 경우 8*8인 64로부터 빼는 것으로 한다.
*/

public class main_1018 {
    public static char[][] chess;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int small = 2500; //최댓값으로 잡아놓기

        chess = new char[n][m];

        for (int k = 0; k < n; k++) {
            chess[k] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n - 7; i++) { //이 내부에서 또 비교
            for (int j = 0; j < m - 7; j++) {
                small = Math.min(small, find(i, j));
            }
        }
        System.out.println(small);
    }

    public static int find(int i, int j) {
        //초기 collect 값을 잡아야 한다.
        char TF = chess[i][j];
        int count = 0;

        for (int w = i; w < i + 8; w++) {
            for (int z = j; z < j + 8; z++) {
                if (chess[w][z] != TF) { //같지 않다면 추가해야 한다.
                    count++;
                }
                if (TF == 'W') { //TF swop
                    TF = 'B';
                } else {
                    TF = 'W';
                }
            }
            //swop
            if (TF == 'W') { //TF swop
                TF = 'B';
            } else {
                TF = 'W';
            }
        }
        return (Math.min(count, 64 - count));
    }
}
