package 자바_백준.백준_실버2.복습;

import java.io.*;
import java.util.*;

class Graph{

    class Node{
        int data;
        boolean visit;
        LinkedList<Node> link;

        Node(int data){
            this.data = data;
            visit = false;
            link = new LinkedList<>();
        }
    }

    Node[] nodes;
    Graph(int size){
        nodes = new Node[size+1];
        for(int i = 1; i<= size; i++){
            nodes[i] = new Node(i);
        }
    }

    public void add(int a, int b){
        Node n1 = nodes[a];
        Node n2 = nodes[b];

        //연결
        if(!n1.link.contains(n2)){
            n1.link.add(n2);
        }

        if(!n2.link.contains(n1)){
            n2.link.add(n1);
        }
    }

    //stack
    public void dfs(int i){
        Stack<Node> st = new Stack<>();
        Node n = nodes[i];
        st.push(n);

        while(!st.isEmpty()){
            Node n1 = st.pop();
            if(!n1.visit){
                n1.visit = true;

                List<Integer> ll = new ArrayList<>();
                for(Node nd : n1.link){
                    ll.add(nd.data);
                }

                Collections.sort(ll,Collections.reverseOrder()); //reverse order해서 올리기

                for(int j = 0; j<ll.size();j++){
                    st.push(nodes[ll.get(j)]);
                }
                System.out.print(n1.data + " ");
            }
        }
        System.out.println();
    }

    //bfs
    public void bfs(int i){
        Queue<Node> que = new ArrayDeque<>();
        que.add(nodes[i]);

        while(!que.isEmpty()){
            Node n1 = que.poll();
            if(!n1.visit){
                n1.visit = true;

                List<Integer> ll = new ArrayList<>();
                for(Node nd : n1.link){
                    ll.add(nd.data);
                }
                Collections.sort(ll);

                for(int j = 0; j<ll.size();j++){
                    que.add(nodes[ll.get(j)]);
                }

                System.out.print(n1.data + " ");
            }
        }
        System.out.println();
    }

}
public class main_1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //노드 개수
        int m = Integer.parseInt(st.nextToken()); //간선 개수
        int v = Integer.parseInt(st.nextToken()); //시작

        Graph gh = new Graph(n);
        Graph gh2 = new Graph(n);

        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            gh.add(a, b);
            gh2.add(a, b);
        }

        gh.dfs(v);
        gh2.bfs(v);

    }
}
