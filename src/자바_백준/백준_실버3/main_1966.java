package 자바_백준.백준_실버3;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class main_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine()); //몇 바퀴를 돌 것인가 하는 문제이다.

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int cnt = 0;

            int max = 0;

            LinkedList<Integer[]> que = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int stNum = Integer.parseInt(st.nextToken());

                que.add(new Integer[]{j, stNum}); //배열 생성 문법 주의
            }

            while(!que.isEmpty()){
                //우선순위 가장 큰 수 찾기
                for (int z = 0; z < que.size(); z++) {
                    if(que.get(z)[1] > max){
                        max = que.get(z)[1];
                    }
                }

                while(que.peek()[1] != max){
                    que.addLast(que.pop()); //뒤로 보내기
                }

                //que.peek()[1] == max

                //찾던 것인지 확인
                if(que.peek()[0] == m){ //같은 인덱스
                    que.clear(); //끝 조건을 위함
                }else{ //다른 인덱스
                    que.pop();
                }

                cnt++; //전부 한 번의 연산
                max = 0; //초기화

            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
