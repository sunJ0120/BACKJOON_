package 자바_백준.백준_실버1;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class main_1697 {

    static int m;
    static int high;

    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        isVisit = new boolean[100000+1]; //*2, +1, -1

        high = 0;

        bfs(n);

        bw.write(high + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(int start){
        Queue<Integer> que = new ArrayDeque<>();
        Queue<Integer> distance = new ArrayDeque<>();

        que.add(start);
        distance.add(0);

        while(true){
            int n = que.poll();
            int dis = distance.poll();

            if(n == m){
                high = dis;
                break;
            }

            if(!isVisit[n]){
                isVisit[n] = true;

                if(n*2 <= m+1){ //m -> m+1
                    que.add(n*2); //*2
                    distance.add(dis+1);
                }

                if(n+1 <= m+1){ //m+1이어야 다음에 뺄 수 있다!
                    que.add(n+1); //+1
                    distance.add(dis+1);
                }

                if(n-1 >= 0){ // && n-1 >= m X
                    que.add(n-1); //-1
                    distance.add(dis+1);
                }
            }
        }
    }
}
