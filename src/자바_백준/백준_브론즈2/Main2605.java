package 자바_백준.백준_브론즈2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> line = new LinkedList<>();

        //리스트 초기화
        for(int i = 0; i<num; i++){
            line.add(i+1);
        }

        //자리바꿈표
        for(int i = 0; i<num; i++){
            int change = Integer.parseInt(st.nextToken());
            line.remove(i); //짜피 앞으로 가기 때문에 인덱스 변화 없음
            line.add(i-change, i+1);
        }

        for(int n : line){
            stb.append(n + " ");
        }
        System.out.println(stb);
        br.close();
    }
}
