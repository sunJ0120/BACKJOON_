package 자바_백준.백준_실버4;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

/*
1. 정렬
2. 곱하기 (병렬 연결 가능 수만큼)
 */

public class main_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        List<Integer> roopList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            roopList.add(Integer.parseInt(br.readLine()));
        }

        sort(roopList);

        int ans = roopList.get(0) * num;

        for (int i = 1; i < num; i++) {
            int n = roopList.get(i) * (num-i);

            if(n > ans){
                ans = n;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        br.close();
        bw.close();

    }
}
