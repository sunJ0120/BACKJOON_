package 자바_백준.개념;

import java.io.*;
import java.util.*;

class Node_D implements Comparable<Node_D>{
    int index;
    int cost;

    public Node_D(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node_D o){
        return Integer.compare(this.cost, o.cost); //새로 들어온 o.cost가 더 작다면, 1이 나와서 우선순위로 올라간다.
    }
}
public class Dijkstra_2 {
    static ArrayList<Node_D>[] graph; //graph[1] = [Node(2, 4), Node(3, 1)]; 이런식으로 연결된다.

    //노드의 크기, 출발지
    public static void Dijkstra(int n, int start){
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n+1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0; //자기 자신 이므로 0으로 잡는다.

        PriorityQueue<Node_D> pq = new PriorityQueue<>();
        pq.offer(new Node_D(start, 0)); //자기 자신 이므로, 가중치를 0으로 설정한다.

        while(!pq.isEmpty()){
            int nowVertex = pq.poll().index;

            if(check[nowVertex]) continue;
            check[nowVertex] = true;

            //index의 연결된 정점을 비교한다.
            for(Node_D next : graph[nowVertex]){ //현재 정점과 연결된 next들을 방문한다. graph[nowVertex]
                if(dist[next.index] > dist[nowVertex] + next.cost){
                    dist[next.index] = dist[nowVertex] + next.cost;

                    pq.offer(new Node_D(next.index, dist[next.index])); //바꾸고, 새로운 cost 값을 올린다. 이래야 다음 방문할 node를 구할 수 있다.
                }
            }
        }

        //최소거리 출력
        for(int i : dist){
            if(i == INF) System.out.print(0 + " ");
            else System.out.print(i + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        //그래프 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //정점의 개수, 간선의 개수
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for(int i = 0; i<= n; i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Node_D(w, cost));
        }

        int start = Integer.parseInt(br.readLine());
        Dijkstra_2.Dijkstra(n,start);
    }
}
