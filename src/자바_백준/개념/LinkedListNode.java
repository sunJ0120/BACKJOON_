package 자바_백준.개념;
class LinkedList {
    Node header;
    static class Node{
        int data;
        Node next = null;
    }
    LinkedList(){
        header = new Node();
    }

    void append(int data){
        Node end = new Node();
        end.data = data;
        Node n = header;

        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void delete(int data){
        Node n = header;
        while(n.next != null){
            if (n.next.data == data) {
                n.next = n.next.next; //새로이 연결
            }else{
                n = n.next; //이동
            }
        }
    }

    void retrieve(){
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data);
    }
}

public class LinkedListNode{
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.retrieve();
        ll.delete(2);
        ll.retrieve();
    }
}
