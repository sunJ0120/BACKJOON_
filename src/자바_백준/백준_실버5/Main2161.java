package 자바_백준.백준_실버5;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main2161 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        Queue<Integer> que = new ArrayDeque<>();

        for(int i = 1; i<=num; i++){
            que.add(i);
        }

        while(!que.isEmpty()){
            bw.write(que.poll() + " ");
            if(que.isEmpty()){
                break;
            }
            que.add(que.poll());
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
