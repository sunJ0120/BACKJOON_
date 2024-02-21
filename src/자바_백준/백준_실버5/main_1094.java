package 자바_백준.백준_실버5;

import java.io.*;

public class main_1094 {
    public static int st = 0;
    public static int ans = 0;

    public static int stick(int n, int m) { //bottom-up 방식으로

        while(n != st){
            if(st + m <= n){ //더했을때 n보다 작거나 같으면 더할 수 있음, 아니면 막대만 나누고 넘어가기
                st += m;
                ans++;
            }
            if(m > 1){
                m /= 2;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(stick(n, 64) + "\n");
        bw.flush();
        br.close();
        bw.close();

    }
}
