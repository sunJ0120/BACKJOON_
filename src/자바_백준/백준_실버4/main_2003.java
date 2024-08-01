package 자바_백준.백준_실버4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
- start, end index를 두고 누적합을 계산한다.
- 주어진 수 이상일시 멈춘다.(그 수열에서는 주어진 수 값이 나올 수 없다.)
 */
public class main_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int ansNum = Integer.parseInt(st.nextToken());

        List<Integer> numList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }

        int start = 0;
        int end = start;

        int ans = 0;

        int ansSum = 0;

        while(start < num){
            if(ansSum < ansNum){
                if(end >= num){
                    start++;
                    end = start;
                    ansSum = 0; //초기화
                }else{
                    ansSum += numList.get(end);
                    end++;
                }
            }else if(ansSum == ansNum){
                ans++;
                start++;
                end = start; //초기화
                ansSum = 0; //초기화
            }else{
                start++;
                end = start;
                ansSum = 0; //초기화
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
