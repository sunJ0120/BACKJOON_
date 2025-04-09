package 자바_백준.백준_실버5;

import java.io.*;
import java.util.StringTokenizer;

public class Main2740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());

        int[][] a = new int[n1][m1];

        makeMatrix(n1, st, br, m1, a);

        st = new StringTokenizer(br.readLine());

        int n2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());

        int[][] b = new int[n2][m2];

        makeMatrix(n2, st, br, m2, b); //ctrl alt m으로 method 추출

        int[][] c = new int[n1][m2];

        for(int i = 0; i<n1; i++){
            for(int j = 0; j<m2; j++){
                for(int z = 0; z<n2; z++){
                    c[i][j] += a[i][z] * b[z][j];
                }
                bw.write(c[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void makeMatrix(int n1, StringTokenizer st, BufferedReader br, int m1, int[][] a) throws IOException {
        for (int i = 0; i < n1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m1; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
