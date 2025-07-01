package 자바_백준.백준_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //물품의 수
        int k = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게

        List<int[]> bag = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int[] things = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; //무게, 가치
            bag.add(things);
        }

        Collections.sort(bag, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){ //가치가 같으면 무게 오름차순
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1]; //기본적으로 가치 내림차순
            }
        });

        for(int i = 0; i<bag.size(); i++){
            int kg = k; //최대 무게 가져오기
            int value = 0; //각 세트별 가치 계산
            for(int j = i; j<bag.size(); j++){
                if(kg >= bag.get(j)[0]){ //여기 j랑 i 헷갈리지 말자.
                    kg -= bag.get(j)[0];
                    value += bag.get(j)[1]; //가치 누적
                }else{
                    break; //현재 시작값에 해당하는 루프 종료
                }
            }
            max = Math.max(value, max); //누적 가치랑 최곳값 비교.
        }
        System.out.println(max);
    }
}
