package 자바_백준.백준_실버4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class main_1920_2 {

    //인덱스 절반 함수
    public static int halfIndex(int start, int end){
        return ((end - start)/2) + start; //시작점을 더해야 한다.
    }

    //검색 함수
    public static int binarySort(int start, int end, int a, List<Integer> numList){
        //종료조건, 없는 경우
        if(start > end){
            return 0;
        }
        //절반
        int half = halfIndex(start, end);

        if(numList.get(half) < a){
            return binarySort(half+1, end, a, numList);
        }else if(numList.get(half) > a){
            return binarySort(start, half-1, a, numList);
        }else{
            return 1; //값에 해당함
        }
    }

    //메인 함수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine()); //처음 주어지는 수
        List<Integer> numList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(numList);

        int n = Integer.parseInt(br.readLine()); // 비교할 수 갯수
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int inputNum = Integer.parseInt(st.nextToken());
            int ans = binarySort(0, num - 1, inputNum, numList);
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
