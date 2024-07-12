package 자바_백준.백준_실버4;

import java.io.*;
import java.util.*;

import static java.util.Collections.sort;

/*
교집합을 구하는 문제인데..

탐색 시간이 관건이겠다.
일단 간단하게 map을 이용해보자.

우선 정렬하는게 좋을듯
 */
public class main_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int listen = Integer.parseInt(st.nextToken());
        int look = Integer.parseInt(st.nextToken());

        Set<String> lis = new HashSet<>();
        Set<String> lok = new HashSet<>();

        for(int i = 0; i < listen; i++){
            lis.add(br.readLine());
        }

        for(int i = 0; i < look; i++){
            lok.add(br.readLine());
        }

        //* set에서 집합
        lis.retainAll(lok);

        //* List로 변환
        List<String> ans = new ArrayList<>(lis);

        sort(ans);

        System.out.println(ans.size());

        for (int i = 0; i < ans.size(); i++) {
            bw.write(ans.get(i));
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
