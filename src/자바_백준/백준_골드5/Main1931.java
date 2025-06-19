package 자바_백준.백준_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1931 - 회의실 배정
 * - 이거 완전탐색을 할 필요도 없는 문제다!!!
 * - 그냥 정렬해서 타고타고 가다보면 최소가 보장되는 아름다운 문제이다....
 * - 너무 즐겁다.
 */
public class Main1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roop = Integer.parseInt(br.readLine());
        int cnt = 1;

        List<int[]> lists = new ArrayList<>(); //이중 리스트로 구현한다.

        for(int i = 0; i<roop; i++){
            int[] innerList = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            innerList[0] = Integer.parseInt(st.nextToken());
            innerList[1] = Integer.parseInt(st.nextToken());

            lists.add(innerList); //list에 구성된 innerList 추가하기
        }

        //내부에 있는걸로 비교하니까 이렇게 int[]를 써줘야 한다!
        Collections.sort(lists, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){ //같을 경우
                    //같을 경우, 시작으로 정렬해야 다음으로 간다.
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1]; //두번째 요소로 오름차순 정리한다.
            }
        });

        int ind = 0;
        int initNum = lists.get(ind++)[1]; //초기 시작값 설정
        while(ind < roop){
            if(lists.get(ind)[0] >= initNum) {
                cnt++;
                initNum = lists.get(ind)[1];
            }
            ind++;
        }
        System.out.println(cnt);
    }
}
