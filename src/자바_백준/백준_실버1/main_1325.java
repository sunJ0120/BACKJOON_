package 자바_백준.백준_실버1;

import java.io.*;
import java.util.*;

class Graph_1325{

    class Node{
        int data;
        boolean visit;
        List<Node> linked;
        Node(int data){
            this.data = data;
            visit = false;
            linked = new ArrayList<>();
        }
    }
    int[] maxList;
    Node[] nodes;

    Graph_1325(int size){
        nodes = new Node[size+1];
        for(int i = 1; i<=size;i++){
            nodes[i] = new Node(i);
        }
        maxList = new int[size+1];
    }

    public void add(int a, int b){
        Node n1 = nodes[a];
        Node n2 = nodes[b];

        if(!n2.linked.contains(n1)){
            n2.linked.add(n1);
        }
    }

    boolean[] memo;

    public void bfs(int start, int size){
        memo = new boolean[size+1];

        Node n = nodes[start];
        Queue<Object[]> que = new ArrayDeque<>();
        int dep = 0;
        int maxDep = 0;
        que.add(new Object[]{n ,dep});

        while(!que.isEmpty()){
            Object[] qp = que.poll();
            Node n1 = (Node) qp[0];
            int dept = (int) qp[1];

            if(!n1.visit){
                n1.visit = true;
                memo[n1.data] = true;
                for(Node n2: n1.linked){
                    que.add(new Object[]{n2 ,dept+1});
                    if(dept+1 > maxDep){
                        maxDep = dept+1; //다음 dept로 갱신.
                    }
                }
            }
        }
        maxList[start] = maxDep;
    }
}

public class main_1325 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //노드 수
        int m = Integer.parseInt(st.nextToken()); //간선 수

        Graph_1325 gh = new Graph_1325(n);

        int[] bl = new int[n+1];

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            gh.add(a, b);

            //자식 -> 부모 불가능
            //부모 -> 자식 가능
            if(bl[a] == 0 || bl[a] == 2){ //부모 node인 줄 알았는데 자식 node가 될 수 있다.
                bl[a] = 1;
            }

            if(bl[b] == 0) { //아무것도 입력 안 된 상태여야 부모 node 가능
                bl[b] = 2;
            }
        }

        int maxD = 0;
        List<Integer> ll = new ArrayList<>(); //담기 위함

        for(int i = 1; i<bl.length; i++){
            if(bl[i] == 2) { //아무것도 연결 안 된 부모노드일 경우,
                gh.bfs(i,n);
                if(gh.maxList[i] > maxD){
                    maxD = gh.maxList[i]; //최고 높이 찾기.
                }

                //방문 초기화
                for(int j = 1; j<gh.memo.length;j++){
                    if(gh.memo[j]){ //방문한 적 있음
                        gh.nodes[j].visit = false;
                    }
                }
            }
        }

        for(int i = 1; i<gh.maxList.length; i++){
            if(maxD == gh.maxList[i]){
                ll.add(i); //같은거 있으면 더하기
            }
        }

        Collections.sort(ll);

        for(int i = 0; i<ll.size();i++){
            bw.write(ll.get(i) + " ");
        }
        bw.write("\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
