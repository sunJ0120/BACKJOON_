package 자바_백준.백준_실버3;

import java.io.*;
import java.util.*;

public class Main1966_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 - o2) * -1;
            }
        });
        Queue<Integer[]> que = new ArrayDeque<>();

        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); //수
            int m = Integer.parseInt(st.nextToken()); //index

            int ind = 0;
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                int prior = Integer.parseInt(st.nextToken());
                que.add(new Integer[]{ind++,prior});
                pq.offer(prior);
            }

            int cnt = 1;

            while(true){
                if(que.peek()[1] == pq.peek()){
                    if(que.peek()[0] == m){
                        bw.write(cnt +"\n");
                        break;
                    }else{ //우선순위 이지만 인덱스가 아님,
                        cnt++;
                        pq.poll();
                        que.poll(); //que도 비워줘야 한다.
                    }
                }else{
                    que.offer(que.poll()); //뒤로 보내기, 순서가 아님
                }
            }
            pq.clear();
            que.clear();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
