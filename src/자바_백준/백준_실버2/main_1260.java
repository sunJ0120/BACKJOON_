package 자바_백준.백준_실버2;

import java.io.*;
import java.util.*;

class Graph{
    public class Node{
        int i; //숫자
        boolean visit; //방문 여부
        LinkedList<Node> link; //연결 list

        Node(int i){ //생성자
            this.i = i;
            visit = false;
            link = new LinkedList<Node>();
        }
    }
    Node[] nodes;
    Graph(int size){
        nodes = new Node[size+1];
        for(int i = 1; i<=size; i++) {
            nodes[i] = new Node(i);
        }
    }
    //양쪽으로 연결
    public void add(int a, int b){
        Node n1 = nodes[a];
        Node n2 = nodes[b];

        if(!n1.link.contains(n2)){
            n1.link.add(n2);
        }

        if(!n2.link.contains(n1)){
            n2.link.add(n1);
        }
    }

    //재귀 아니고 stack으로 구현
    public void dfs(int start){
        Stack<Node> st = new Stack<>();
        Node root = nodes[start]; //root node로 쓸 것 꺼내기

        st.push(root);

        while(!st.isEmpty()){
            List<Integer> nd = new ArrayList<>();

            Node n2 = st.pop();

            if(!n2.visit) {
                n2.visit = true; //방문 했음.
            }else{
                continue;
            }

            //내부 자식들 돌기

            for(Node r: n2.link){
                if(!r.visit) {
                    nd.add(r.i);
                }
            }

            Collections.sort(nd, Collections.reverseOrder());
            for(int i: nd){
                st.push(nodes[i]);
            }
            System.out.print(n2.i + " ");
        }
        System.out.println();
    }

    //재귀 아니고 Queue로 구현
    public void bfs(int start){
        Queue<Node> qu = new ArrayDeque<>();
        Node n1 = nodes[start];

        qu.add(n1);

        while(!qu.isEmpty()){
            List<Integer> nd = new ArrayList<>();
            Node n2 = qu.poll();

            if(!n2.visit) {
                n2.visit = true; //방문 했음.
            }else{
                continue;
            }

            for(Node n:n2.link){
                if(!n.visit) {
                    nd.add(n.i);
                }
            }

            Collections.sort(nd);
            for(int i: nd){
                qu.add(nodes[i]);
            }

            System.out.print(n2.i + " ");
        }
        System.out.println();
    }
}

public class main_1260 {

    public static int n; //node의 개수
    public static int m; //간선의 개수
    public static int k; //start node

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //node의 개수
        m = Integer.parseInt(st.nextToken()); //간선의 개수
        k = Integer.parseInt(st.nextToken()); //시작점

        Graph gh = new Graph(n); //node 설정 완
        Graph gh2 = new Graph(n); //node 설정 완

        for(int i = 0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            gh.add(a,b);
            gh2.add(a,b);
        }

        gh.dfs(k);
        gh2.bfs(k);

    }
}
