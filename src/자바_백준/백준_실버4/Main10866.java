package 자바_백준.백준_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Deque<Integer> que = new ArrayDeque<>();

        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int n = st.hasMoreTokens() ? Integer.parseInt(st.nextToken()) : 0;

            if(str.equals("push_front")){
                push_front(que,n);
            }else if(str.equals("push_back")){
                push_back(que,n);
            }else if(str.equals("pop_front")){
                System.out.println(pop_front(que));
            }else if(str.equals("pop_back")){
                System.out.println(pop_back(que));
            }else if(str.equals("size")){
                System.out.println(size(que));
            }else if(str.equals("empty")){
                System.out.println(empty(que));
            }else if(str.equals("front")){
                System.out.println(front(que));
            }else if(str.equals("back")){
                System.out.println(back(que));
            }else{
                System.out.println("error");
            }
        }
    }

    public static void push_front(Deque<Integer> que, int n){
        que.addFirst(n);
    }

    public static void push_back(Deque<Integer> que,int n){
        que.addLast(n);
    }

    public static int pop_front(Deque<Integer> que){
        if(que.isEmpty()){
            return -1;
        }
        return que.pollFirst();
    }

    public static int pop_back(Deque<Integer> que){
        if(que.isEmpty()){
            return -1;
        }
        return que.pollLast();
    }

    public static int size(Deque<Integer> que){
        return que.size();
    }

    public static int empty(Deque<Integer> que){
        return que.isEmpty() ? 1 : 0;
    }

    public static int front(Deque<Integer> que){
        if(que.isEmpty()){
            return -1;
        }
        return que.peekFirst();
    }

    public static int back(Deque<Integer> que){
        if(que.isEmpty()){
            return -1;
        }
        return que.peekLast();
    }
}
