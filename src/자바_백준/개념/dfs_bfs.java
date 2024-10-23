package 자바_백준.개념;

import java.util.LinkedList;
import java.util.Stack;

class Queue<T>{

}

class Graph{
    class Node{
        int data;
        LinkedList<Node> adjacent; //인접한 node들과의 관계
        boolean marked;
        Node (int data){ //초기화
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }
    }

    /*
    Graph
     */
    Node[] nodes;
    Graph(int size){
        nodes = new Node[size]; //배열방
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    /*
    관계를 저장하는 함수
     */
    void addEgde(int i1, int i2){
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];

        //두개의 node에 서로가 있는지 확인하고, 추가
        if(!n1.adjacent.contains(n2)){
            n1.adjacent.add(n2);
        }

        if(!n2.adjacent.contains(n1)){
            n2.adjacent.add(n1);
        }
    }

    void dfs(){ //시작하면 0부터 시작한다.
        dfs(0);
    }

    void dfs(int index){
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true; //stack에 들어갔다고 표시한다.

        //stack에 데이터가 없을때까지 반복한다.
        while(!stack.isEmpty()){
            Node r = stack.pop();
            for(Node n : r.adjacent){
                if (n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    void visit(Node n){
        System.out.println(n);
    }

}



public class dfs_bfs {
    public static void main(String[] args) {

    }
}
