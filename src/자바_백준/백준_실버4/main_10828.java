package 자바_백준.백준_실버4;

import java.io.*;
import java.util.*;

public class main_10828 {
    static List<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        stack = new ArrayList<>();

        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();

            if(comm.equals("push")){
                int n = Integer.parseInt(st.nextToken());
                push(n);
            }else if(comm.equals("pop")){
                bw.write(pop() + "\n");
            }else if(comm.equals("size")){
                bw.write(size() + "\n");
            }else if(comm.equals("empty")){
                bw.write(empty() + "\n");
            }else{
                bw.write(top() + "\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void push(int n){
        stack.add(n);
    }

    public static int pop(){
        if(stack.isEmpty()){
            return -1;
        }else{
            int ans = stack.get(stack.size()-1);
            stack.remove(stack.size()-1);

            return ans;
        }
    }

    public static int size(){
        return stack.size();
    }

    public static int empty(){
        if(stack.isEmpty()){
            return 1;
        }else{
            return 0;
        }
    }

    public static int top(){
        if(stack.isEmpty()){
            return -1;
        }else{
            return stack.get(stack.size()-1);
        }
    }
}
