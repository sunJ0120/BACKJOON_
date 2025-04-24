package 자바_백준.백준_골드4;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int roop = Integer.parseInt(br.readLine());
        int[] index = new int[roop];
        int[] height = new int[roop];
        int[] result = new int[roop];
        Stack<Integer> sta = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<roop; i++){
            index[i] = i;
            height[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i<roop; i++){
            while(!sta.isEmpty() && height[sta.peek()] < height[i]){ //새로 들어오는 수가 더 커야한다.
                result[sta.pop()] = height[i];
            }
            sta.push(i);
        }

        while(!sta.isEmpty()){
            result[sta.pop()] = -1;
        }

        for(int n : result){
            bw.write(n + " ");
        }
        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
