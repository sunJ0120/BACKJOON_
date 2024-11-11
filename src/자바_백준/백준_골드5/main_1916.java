package 자바_백준.백준_골드5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{

    int index;
    int cost;
    Node(int index, int cost){ //node안에는 각 인덱스와 연결 cost
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost); //o.cost가 더 낮으면 된다.
    }
}
public class main_1916 {

    static ArrayList<Node>[] Graph;
    static int[] dist;

    public static void dijkstra(int n, int start){
        boolean[] visit = new boolean[n+1]; //방문 저장
        dist = new int[n+1];

        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0; //자기 자신은 0이다.

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            int nowVertex = pq.poll().index;
            if(visit[nowVertex]){
                continue;
            }
            visit[nowVertex] = true;

            for(Node n1 : Graph[nowVertex]){ //Graph[nowVertex] 안에 연결된 것들이 list로 있다.
                if(dist[n1.index] > dist[nowVertex] + n1.cost){
                    dist[n1.index] = dist[nowVertex] + n1.cost;

                    pq.offer(new Node(n1.index, dist[n1.index]));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        Graph = new ArrayList[n+1]; //이중으로 만들기 위해 이중으로 설정

        for(int i = 0; i<=n; i++){
            Graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Graph[a].add(new Node(b,d)); //연결 관계를 더해주기
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(n, start);

        bw.write(dist[end] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
