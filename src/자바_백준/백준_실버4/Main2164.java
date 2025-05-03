package 자바_백준.백준_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Queue<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= num; i++) {
            que.add(i);
        }

        while(que.size() > 1){
            que.poll();
            que.add(que.poll());
        }
        System.out.println(que.poll());
    }
}
