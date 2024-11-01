package 자바_백준.백준_실버2;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Graph_2644{

    class Node_2644{
        int data;
        boolean visit;
        LinkedList<Node_2644> link;

        Node_2644(int i){
            this.data = i;
            visit = false;
            link = new LinkedList<>();
        }
    }

    Node_2644[] nodes;
    Graph_2644(int size){
        nodes = new Node_2644[size+1];
        for(int i = 1; i<= size; i++){
            nodes[i] = new Node_2644(i);
        }
    }

    public void add(int a, int b){
        Node_2644 n1 = nodes[a];
        Node_2644 n2 = nodes[b];

        if(!n1.link.contains(n2)){
            n1.link.add(n2);
        }

        if(!n2.link.contains(n1)){
            n2.link.add(n1);
        }
    }

    public int dfs(int start, int end, int cnt) {

        if(start == end){
            return cnt;
        }

        for(Node_2644 n : nodes[start].link){
            if(!n.visit){
                n.visit = true;
                return dfs(n.data, end, cnt+1);
            }
        }
        return -1; //해당하는게 없을 경우
    }
}
public class main_2644 {

    static Graph_2644 gh;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int road = Integer.parseInt(br.readLine());

        gh = new Graph_2644(num);

        for(int i = 0; i<road;i++){
            st = new StringTokenizer(br.readLine());
            gh.add(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        bw.write( gh.dfs(start, end, 0)+ "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
