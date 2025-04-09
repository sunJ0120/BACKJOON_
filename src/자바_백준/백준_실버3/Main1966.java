package 자바_백준.백준_실버3;

import java.io.*;
import java.util.*;

public class Main1966 {
    static class Print { //class 안에 static class 마련
        int ind;
        int prior;

        public Print(int ind, int prior){
            this.ind = ind;
            this.prior = prior;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        Queue<Print> que = new ArrayDeque<>();

        PriorityQueue<Print> pq = new PriorityQueue<>(new Comparator<Print>() {
            @Override
            public int compare(Print o1, Print o2) { //큰 수 우선으로 바꿔주기 위해
                return (o1.prior - o2.prior) * -1;
            }
        });

        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            int ind = 0;
            while(st.hasMoreTokens()){
                int nn = Integer.parseInt(st.nextToken());
                pq.offer(new Print(ind,nn));
                que.offer(new Print(ind++,nn));
            }

            int cnt = 1;
            while(true){
                if(pq.peek().prior == que.peek().prior){ //우선도 비교
                    if(que.peek().ind == m){ //순서 비교
                        bw.write(cnt + "\n");
                        break;
                    }else{
                        que.poll();
                        pq.poll();
                        cnt++;
                    }
                }else{
                    que.offer(que.poll());
                }
            }
            pq.clear();
            que.clear();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
