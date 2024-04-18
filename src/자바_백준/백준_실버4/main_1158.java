package 자바_백준.백준_실버4;

import java.io.*;
import java.util.*;

/*
요세푸스 문제
중요한 것은, n을 나눈 나머지를 구해서 그걸 하나하나 지워가는 것이다.
이거 헷갈리는데, 안에서 계속 돌아야 하나..? 풀이를 찾아보자.
 */

/*
좀 헷갈리는데, 시작값을 어떻게 매겨..?
 */
public class main_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer stb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 1;

        stb.append("<");

        List<Integer> yosep = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            yosep.add(i);
        }

        int baseIndex = 0;

        while(yosep.size()>1){ //뒤에 하나 남았을때
            int nextIndex = (((baseIndex+(k-1))%yosep.size())); //(baseIndex+(k-1) 여기 이 부분이랑, size로 나누는 부붕 주의!

            stb.append(yosep.get(nextIndex));
            stb.append(", ");
            baseIndex = nextIndex; //시작점을 차지하기 위해서
            yosep.remove(nextIndex);
        }
        stb.append(yosep.get(0)); //남은거 하나 가져오기
        stb.append(">");

        System.out.println(stb);
        br.close();
    }
}
