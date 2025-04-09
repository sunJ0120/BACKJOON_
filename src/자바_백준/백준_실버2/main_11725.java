package 자바_백준.백준_실버2;

import java.io.*;
import java.util.*;

public class main_11725 {
    static class Graph_11725{
        class Node{
            int data;
            boolean visit;
            List<Node> link;
            Node(int data){
                this.data = data;
                visit = false;
                link = new ArrayList<Node>();
            }
        }

        Node[] nodes;

        Graph_11725(int size){
            nodes = new Node[size + 1];
            for(int i = 1; i<=size; i++){
                nodes[i] = new Node(i);
            }
        }

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

        int parent = 0;
        int child = 0;

        public void dfs(int start){
            Node n = nodes[start];
            n.visit = true;

            for(Node n1 : n.link){
                parent = n.data;
                if(!n1.visit) {
                    child = n1.data;
                    ll[child] = parent;
                    dfs(n1.data);
                }
            }
        }
    }

    static int[] ll;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        ll = new int[num+1];

        Graph_11725 gh = new Graph_11725(num);

        for(int g = 0; g<num-1;g++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(st.countTokens() == 0){
                break;
            }

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            gh.add(a, b);
        }

        gh.dfs(1);

        for(int j = 2; j<ll.length;j++){
            bw.write(ll[j] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
