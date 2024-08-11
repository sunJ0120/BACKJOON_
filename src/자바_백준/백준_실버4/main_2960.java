package 자바_백준.백준_실버4;

import java.io.*;
import java.util.StringTokenizer;

/*
N까지 리스트 생성
배수 별로 하나씩 늘려가며 1로 채운다
k에 해당하면 count를 return 한다.
 */
public class main_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 0;
        int ans = 0;

        int[] ela = new int[n+1];
        int start = 2;
        int i = start; //누적
        int j = 2; //곱

        while(ans == 0){
            if(ela[i] == 0){
                while(i < n){
                    ela[i] = 1;
                    count += 1;

                    if(count == k){
                        ans += i;
                    }

                    i = start * j;
                    j++;
                }
            }
            j = 2;
            i = start++;
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
