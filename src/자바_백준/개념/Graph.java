package 자바_백준.개념;

public class Graph {
    class Node{
        int data;
        java.util.LinkedList<Node> adjacent; //인접, 연결된 노드
        boolean marked;
        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new java.util.LinkedList<Node>();
        }
    }
    Node[] nodes; //graph 생성을 위한 배열
    Graph(int size){
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    void dfs(){
        dfs(0);
    }
    void dfs(int index){ //root를 지정하기 위함
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root); //root를 우선 push
        root.marked = true;

        while (!stack.isEmpty()) {
            Node r = stack.pop(); //먼저 pop
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new Queue<Node>();
        queue.add(root);
        root.marked = true;
        while (!queue.isEmpty()) {
            Node r = queue.remove();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.add(n);
                }
            }
            visit(r); //print 하기 위한 용도의 fuction
        }
    }

    void bfs(){
        bfs(0);
    }

    void dfsR(Node r) { //재귀를 이용한 dfs
        if(r == null){
            return;
        }
        r.marked = true;
        visit(r); //먼저 출력한다.
        for(Node n : r.adjacent){
            if(n.marked == false){ //false일때까지 출력
                dfsR(n);
            }
        }
    }

    void dfsR(int index){
        Node r = nodes[index];
        dfsR(r);
    }

    void dfsR(){
        dfsR(0);
    }

    void visit(Node node) {
        System.out.print(node.data + " ");
    }

    /*

      0
     /
    1 -- 3    7
    |  / | \ /
    | /  |  5
    2 -- 4   \
              6 - 8

     */

    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(5,6);
        g.addEdge(5,7);
        g.addEdge(6,8);

//        g.dfs(); //0번 부터, 0 1 3 5 7 6 8 4 2
//        g.bfs(); //0 1 2 3 4 5 6 7 8

        g.dfsR(); //0 1 2 3 4 5 6 8 7
    }
}
