package 자바_백준.백준_실버5;

import java.io.*;
import java.util.StringTokenizer;

public class Main7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] li = new int[n][];

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            li[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        }

        for(int i = 0; i<n; i++){
            int rank = 1;
            for(int j = 0; j<n; j++){ // i+1을 하면 안되는 이유가, rank를 계속 1로 초기화 하기 때문이다.
                if(i == j){ //같은값
                    continue;
                }

                if(li[i][0] < li[j][0] && li[i][1] < li[j][1]){
                    rank++;
                }
            }
            bw.write(rank + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
