package 자바_백준.개념;

import java.util.NoSuchElementException;

class Queue<T> {
    class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public void add(T item) {
        Node<T> t = new Node<T>(item);

        if (last != null) {
            last.next = t; //last가 있는 경우, 뒤에 붙인다.
        }
        last = t;
        if (first == null) {
            first = last;
        }
    }
    public T remove(){
        if (first == null) {
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;

        if(first == null){
            last = null; //같이 null로 만들어 줘야한다.
        }
        return data;
    }

    public T peek(){
        if(first == null){
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());
    }
}
