package 자바_백준.백준_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1931 - 회의실 배정
 * - 완전 탐색을 이용해서 범위를 줄여나가는 방법으로 풀어보자.
 */
public class Main1931 {
    static List<List<Integer>> li;
    static int max;

    //i는 인덱스, 이 이후부터 진행한다.
    public static void findRoom(List<Integer> li2, int i, int cnt){
        if(i >= li.size()){
            max = Math.max(max,cnt); //max값을 저장한다.
            return;
        }

        if(li.get(i).get(0) >= li2.get(1)){
            findRoom(li.get(i), i+1, cnt+1); //다음값으로 이동한다.
        }else{
            findRoom(li2, i+1, cnt); //그대로 가서 다른 값을 찾는다.
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roop = Integer.parseInt(br.readLine());
        li = new ArrayList<>();
        max = 0; //0으로 초기화

        for(int i = 0; i<roop; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> li2 = new ArrayList<>();
            li2.add(Integer.parseInt(st.nextToken()));
            li2.add(Integer.parseInt(st.nextToken()));

            li.add(li2);
        }

        for(int i = 0; i<roop; i++){
            List<Integer> li2 = li.get(i);
            findRoom(li2, i, 1); //이미 하나를 선택한거라서

            if(roop - i <= max){
                break; //더 적게 남았으면 의미가 없다.
            }
        }
        System.out.println(max);
    }
}
