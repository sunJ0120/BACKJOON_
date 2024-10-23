package 자바_백준.개념;

class Node{
    int data;
    Node next = null;

    Node(int data) {
        this.data = data;
    }

    void append(int data){
        Node end = new Node(data);
        Node n = this;

        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void delete(int data){
        Node n = this;
        while(n.next != null){
            if (n.next.data == data) {
                n.next = n.next.next; //새로이 연결
            }else{
                n = n.next; //이동
            }
        }
    }

    void retrieve(){
        Node n = this;
        while (n.next != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data);
    }
}
public class LinkedList {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.append(2);
        n.append(3);
        n.append(4);

        n.delete(2);
        n.retrieve();
    }
}
