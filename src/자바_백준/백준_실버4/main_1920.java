package 자바_백준.백준_실버4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Collections.sort;

/*
이분탐색 문제

스택 오버플로우 발생...
 */
public class main_1920 {
    public static int half(List<Integer> numList,int start, int end){
        return ((end-start)/2) + start; //이 절반 구하는 부분때문에 헷갈림
    }
    public static int binarySort(List<Integer> numList, int a, int start, int end){
        int num = half(numList,start,end); //절반값

        if(start > end){ //역전될때
            return 0; //값이 없음
        }

        if(numList.get(num) < a){
            return binarySort(numList, a,num+1, end); //오른쪽 //2. 여기 return 부분때문에 헷갈림
        }else if(numList.get(num) > a){
            return binarySort(numList, a,start,num-1); //왼쪽
        }else{
            return 1; //있음
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> numList = new ArrayList();

        for (int i = 0; i < num; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }
        sort(numList); //정렬

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int ans = binarySort(numList, Integer.parseInt(st.nextToken()), 0, numList.size()-1);
            bw.write(ans + "\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }
}
