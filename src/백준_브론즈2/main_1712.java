package 백준_브론즈2;

import java.io.*;
import java.util.StringTokenizer;

/*
1. 애초에 B >= C 이면 손익분기점이 생길 수 없다.
2. 손익분기점 매출 구하는 공식
(손익분기점 매출 개수) = (A(고정비) / C(가격) - B(비용)) + 1 (손익분기점 이득이 시작되는 부분을 찾기 위해 +1)

 */
public class main_1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if(B >= C){ //손익분기점 불가
            bw.write(-1 + "\n");
        }else{
            bw.write(((A/(C-B))+1) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
