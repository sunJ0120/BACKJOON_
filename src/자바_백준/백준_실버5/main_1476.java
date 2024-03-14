package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
하나씩 이동해 가면서 각 지점에서 다시 1로 돌아가게끔 하면 될 듯 싶다.

1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19
 */
public class main_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int eNum = Integer.parseInt(st.nextToken());
        int sNum = Integer.parseInt(st.nextToken());
        int mNum = Integer.parseInt(st.nextToken());

        int e = 1;
        int s = 1;
        int m = 1;

        int ans = 1;

        while(!(eNum == e && sNum == s && mNum == m)){
            if(e > 15){
                e = 1;
                continue;
            }
            if(s > 28){
                s = 1;
                continue;
            }
            if(m > 19){
                m = 1;
                continue;
            }
            e++; s++; m++;
            ans++; //1년 추가
        }

        System.out.println(ans);
    }
}
