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
        stb.append("<");

        LinkedList<Integer> yosep = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            yosep.add(i);
        }
        int baseIndex = 0;
        int index;

        while(yosep.size() > 1){ //k-1 : 3씩 이동이지만, 인덱스상 2씩 이동해야 한다.
            index = (baseIndex+(k-1))%yosep.size(); //인덱스 설정, size로 나눠야 이를 넘어가지 않는다.
            stb.append(yosep.get(index));
            stb.append(", ");
            baseIndex = index; //시작 위치 변경
            yosep.remove(index);
        }

        stb.append(yosep.pop() + ">");
        System.out.println(stb);
    }
}
