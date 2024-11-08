package 자바_백준.백준_실버2;

import java.io.*;
import java.util.StringTokenizer;

public class main_16953 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        cnt = -1;

        dfs(a,b,1);

        bw.write(cnt + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(long a, long b, int count) {
        if(a == b){
            cnt = count;
            return;
        }

        if(a*2 <= b){
            dfs(a*2,b, count+1);
        }

        if(a*10+1 <= b){
            dfs(a*10+1,b,count+1);
        }
    }
}
