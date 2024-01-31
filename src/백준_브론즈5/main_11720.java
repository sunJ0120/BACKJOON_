package 백준_브론즈5;

/*
20240127 try
구문이 익숙치 않은 관계로
한번더 복습 필요.
 */

import java.io.*;
import java.util.stream.Stream;

public class main_11720 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        int[] nlist = Stream.of(br.readLine().split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < n; i++) {
            ans += nlist[i];
        }
        bw.write(ans + "\n");

        br.close();
        bw.flush();
        bw.close();

    }
}
