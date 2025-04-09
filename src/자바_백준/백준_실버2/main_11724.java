package 자바_백준.백준_실버2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Graph_11724{

    class Node{
        int data;
        boolean visit;

        List<Node>link;

        Node(int data){
            this.data = data;
            visit = false;
            link = new ArrayList<>();
        }
    }

    Node[] nodes;
    Graph_11724(int size){
        nodes = new Node[size+1];
        for(int i = 1; i<= size;i++){
            nodes[i] = new Node(i);
        }
    }

    public void add(int a, int b){
        Node n1 = nodes[a];
        Node n2 = nodes[b];

        if (!n1.link.contains(n2)) {
            n1.link.add(n2);
        }

        if (!n2.link.contains(n1)) {
            n2.link.add(n1);
        }
    }

    public void dfs(int start){
        Node n = nodes[start];
        n.visit = true;

        for(Node n1 : n.link){
            if(!n1.visit){
                dfs(n1.data);
            }
        }
    }
}

public class main_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //node 갯수
        int m = Integer.parseInt(st.nextToken()); //간선 갯수

        int count = 0;

        //그래프, add
        Graph_11724 gh = new Graph_11724(n);

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            gh.add(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        for(int i = 1; i<=n; i++){
            if(!gh.nodes[i].visit){
                count++;
                gh.dfs(i);
            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
