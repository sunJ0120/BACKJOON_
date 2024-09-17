package 자바_백준.백준_실버3;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class main_1966_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            LinkedList<Integer[]> que = new LinkedList<>();

            int cnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                que.add(new Integer[]{j, Integer.parseInt(st.nextToken())});
            }

            while (!que.isEmpty()) {
                int max = 0; //max값은 계속 갱신된다는 것이 포인트이다.

                //max 찾기
                for (int z = 0; z < que.size(); z++) {
                    if(que.get(z)[1] > max){
                        max = que.get(z)[1];
                    }
                }

                for (int z = 0; z < que.size(); z++) {
                    if(que.peek()[1] < max){
                        que.addLast(que.pop()); //뒤로 보내기
                    }else{
                        break;
                    }
                }

                if(que.peek()[0] == m){ //찾음
                    cnt++;
                    bw.write(cnt + "\n");
                    que.clear();
                }else{
                    cnt++;
                    que.pop();
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
