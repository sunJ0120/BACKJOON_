package 자바_백준.백준_실버1;

import java.io.*;
import java.util.*;


class Graph_1389{

    class Node {
        int data;
        Set<Node> linked;

        Node(int data){
            this.data = data;
            linked = new HashSet<>();
        }
    }

    Node[] nodes;
    Graph_1389(int size){
        nodes = new Node[size + 1];

        for(int i = 0; i<= size; i++){
            nodes[i] = new Node(i);
        }
    }

    public void add(int a, int b){
        Node n1 = nodes[a];
        Node n2 = nodes[b];

        n1.linked.add(n2);
        n2.linked.add(n1); //set을 사용해서 중복 간선을 지우므로, 판별할 필요 없음
    }

    int kebin;

    public void bfs(int start, int size){
        kebin = 0;
        boolean[] visitList = new boolean[size+1];

        Queue<Node> que = new ArrayDeque<>();
        Queue<Integer> distance = new ArrayDeque<>();

        que.add(nodes[start]);
        distance.add(0);

        while(!que.isEmpty()){
            Node n1 = que.poll();
            int de = distance.poll();

            kebin += de;

            for(Node n2 : n1.linked){
                if(!visitList[n2.data]) {
                    visitList[n2.data] = true;
                    que.add(n2);
                    distance.add(de+1);
                }
            }
        }

        //초기화
        for(int i = 1; i<visitList.length; i++){
            if(visitList[i]){ //방문했다.
                visitList[i] = false;
            }
        }
    }
}
public class main_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //node수
        int m = Integer.parseInt(st.nextToken()); //간선 수

        Graph_1389 gh = new Graph_1389(n);

        for(int i = 0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            gh.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] bacon = new int[n+1];
        int ans = 1;

        for (int i = 1; i <= n; i++) {
            gh.bfs(i, n);
            bacon[i] = gh.kebin;
        }

        int minNum = bacon[1]; //기준점

        for(int i = 2; i<=n; i++){
            if(minNum > bacon[i]){
                minNum = bacon[i];
                ans = i;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
