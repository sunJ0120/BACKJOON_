package 자바_백준.백준_실버4;

import java.io.*;
import java.util.*;

public class main_1158_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue que = new ArrayDeque();

        for(int i = 1; i<=n; i++){
            que.add(i);
        }

        int cnt = 1;

        stb.append("<");
        while(!que.isEmpty()){
            if(cnt == k){
                stb.append(que.poll() + ", ");

                cnt = 1;
            }else{
                que.add(que.poll());
                cnt++;
            }
        }

        stb.delete(stb.length()-2,stb.length()); //, 끝 부분의 이 값 제거
        stb.append(">" + "\n");

        System.out.println(stb);
        br.close();
    }
}
