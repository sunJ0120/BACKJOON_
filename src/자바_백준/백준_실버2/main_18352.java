package 자바_백준.백준_실버2;

import java.io.*;
import java.util.*;

class Graph_18352 {

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

    Node[] nodes;
    Graph_18352(int size){
        nodes = new Node[size+1];

        for(int i = 1; i<=size; i++){
            nodes[i] = new Node(i);
        }
    }

    public void add(int a, int b){
        Node na = nodes[a];
        Node nb = nodes[b];

        if(!na.linked.contains(nb)){ //단방향 연결
            na.linked.add(nb);
        }
    }
    List<Integer> ll = new ArrayList<>();

    public void bsf(int start, int count){
        Queue<Object[]> qu = new ArrayDeque<>(); //Object[] 로 선언!

        Node n = nodes[start];
        qu.add(new Object[]{n,0});

        while(!qu.isEmpty()){
            Object[] q = qu.poll();
            Node n1 = (Node) q[0]; //typecasting
            int deep = (int) q[1];

            if(!n1.visit){ //체크를 밖으로 빼서 중복되지 않고 먼저 나온것만 치도록 한다.
                if(deep == count){
                    ll.add(n1.data);
                }

                if(deep > count){ //더 깊게 들어갈 필요 없음.
                    break;
                }

                n1.visit = true;

                for(Node n2 : n1.linked){
                    qu.add(new Object[]{n2,deep+1});
                }
            }
        }
    }

}

public class main_18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //도시갯수(N), 도로 갯수(M), 거리 정보(K), 출발 도시 번호(X)
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        Graph_18352 gh = new Graph_18352(n);

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            gh.add(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        gh.bsf(x,k);

        if(!gh.ll.isEmpty()){
            Collections.sort(gh.ll);

            for(int i = 0; i<gh.ll.size();i++){
                bw.write(gh.ll.get(i) + "\n");
            }
        }else{ //empty
            bw.write(-1 + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
