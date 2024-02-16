package 자바_자료구조.재귀;

import java.io.*;

/*
하노이탑 문제
1. 움직인 원반 수 = 2^n-1
2. 움직임 = hanoi 재귀를 이용
 */
public class 백준_11729 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static double hanoiMove(int n){
        return Math.pow(2,n)-1;
    }

    public static void hanoi(int n, int start, int mid, int to) throws IOException{

        if(n == 1){
            bw.write(start + " " + to + "\n");
            return; //옮길 원반이 하나
        }
        hanoi(n-1, start,to,mid);
        bw.write(start + " " + to + "\n");
        hanoi(n-1, mid,start,to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int ans = (int) hanoiMove(n);
        bw.write(ans + "\n");
        hanoi(n, 1, 2, 3); //start, to, mid 번호

        bw.flush();
        bw.close();
        br.close();
    }
}
