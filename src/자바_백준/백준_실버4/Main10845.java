package 자바_백준.백준_실버4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int roop = Integer.parseInt(br.readLine());

        List<Integer> li = new ArrayList<>();

        for(int i = 0; i<roop; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String comm = st.nextToken();

            if(comm.equals("push")){
                int n = Integer.parseInt(st.nextToken());
                push(li, n);
            }else if(comm.equals("pop")){
                bw.write(pop(li) + "\n");
            }else if(comm.equals("size")){
                bw.write(size(li) + "\n");
            }else if(comm.equals("empty")){
                bw.write(empty(li) + "\n");
            }else if(comm.equals("front")){
                bw.write(front(li) + "\n");
            }else{
                bw.write(back(li) + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void push(List<Integer> li, int num){
        li.add(num);
    }
    public static int pop(List<Integer> li){
        if(li.size() == 0){
            return -1;
        }
        int ans = li.get(0);
        li.remove(0);
        return ans;
    }
    public static int size(List<Integer> li){
        return li.size();
    }
    public static int empty(List<Integer> li){
        return li.isEmpty() ? 1 : 0;
    }

    public static int front(List<Integer> li){
        if(li.size() == 0){
            return -1;
        }
        return li.get(0);
    }

    public static int back(List<Integer> li){
        if(li.size() == 0){
            return -1;
        }
        return li.get(li.size()-1);
    }
}
