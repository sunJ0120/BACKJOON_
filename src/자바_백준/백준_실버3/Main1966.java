package 자바_백준.백준_실버3;

import java.io.*;
import java.util.*;

public class Main1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Integer> que = new ArrayDeque<>();
            Queue<Integer> ind = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());

            int j = 0;
            while(st.hasMoreTokens()){
                int nn = Integer.parseInt(st.nextToken());
                que.add(nn);
                ind.add(j++);
            }

            int cnt = 1;

            while(!que.isEmpty()){
                int max = 0;

                for(int z = 0; z<que.size(); z++){
                    max = Math.max(que.peek(), max);
                    que.add(que.poll());
                }

                if(que.peek() == max){
                    if(ind.peek() == m){
                        bw.write(cnt + "\n");
                        break;
                    }else{
                        que.poll();
                        ind.poll();
                        cnt++;
                    }
                }else{
                    que.add(que.poll());
                    ind.add(ind.poll());
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
