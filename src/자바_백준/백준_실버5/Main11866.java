package 자바_백준.백준_실버5;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new ArrayDeque<>();

        for(int i = 1; i<=n; i++){
            que.add(i);
        }

        stb.append("<");

        int cnt = 1;

        while (!que.isEmpty()) {
            if(cnt == k){
                stb.append(que.poll() + ", ");
                cnt = 1;
            }else{
                que.add(que.poll());
                cnt++;
            }
        }
        stb.delete(stb.length()-2,stb.length());
        stb.append(">");
        System.out.println(stb);
    }
}
