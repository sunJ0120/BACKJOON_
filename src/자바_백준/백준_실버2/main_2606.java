package 자바_백준.백준_실버2;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Graph_2606{

    class Node{
        int data;
        boolean visit;
        LinkedList<Node> linked;
        Node(int data){
            this.data = data;
            visit = false;
            linked = new LinkedList<Node>();
        }
    }

    Node[] nodes;
    Graph_2606(int size){
        nodes = new Node[size+1];
        for(int i = 1; i<= size;i++){
            nodes[i] = new Node(i);
        }
    }

    public void add(int a, int b){
        Node n1 = nodes[a];
        Node n2 = nodes[b];

        if(!n1.linked.contains(n2)){
            n1.linked.add(n2);
        }

        if(!n2.linked.contains(n1)){
            n2.linked.add(n1);
        }
    }

    int count = 0;

    public void dfs(int start){
        Node n = nodes[start];
        n.visit = true;

        for(Node n1 : n.linked){
            if(!n1.visit){
                count++;
                dfs(n1.data);
            }
        }
    }
}

public class main_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int node = Integer.parseInt(br.readLine());
        int vertex = Integer.parseInt(br.readLine());

        Graph_2606 gh = new Graph_2606(node);

        for(int i = 0; i<vertex;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            gh.add(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        gh.dfs(1);

        bw.write(gh.count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
