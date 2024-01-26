package 백준_브론즈5;

import java.io.*;
import java.util.stream.Stream;

public class main_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        int[] ansList = Stream.of(br.readLine()
                .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        //Stream.of을 이용해서 Stream 생성
        //.mapToInt(Integer::parseInt) : String array의 요소 하나하나를 Integer.parseInt를 적용해서 바꾼다.
        //toArray() : array로 변경

        for(int i = 0; i< n; i++){
            ans += ansList[i];
        }

        bw.write(ans + "\n");
        br.close();
        bw.flush();
        br.close();
    }
}
