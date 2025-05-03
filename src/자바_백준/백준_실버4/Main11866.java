package 자바_백준.백준_실버4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("<");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new ArrayDeque<>();

        for(int i = 1; i<=n; i++){
            que.add(i);
        }

        int cnt = 1;

        while(que.size() > 1){
            if(cnt == k){
                bw.write(que.poll() + ", ");
                cnt = 1;
            }else {
                que.add(que.poll()); //뒤로 보내기
                cnt++;
            }
        }
        bw.write(que.poll() + ">");

        bw.flush();
        bw.close();
        br.close();
    }
}
