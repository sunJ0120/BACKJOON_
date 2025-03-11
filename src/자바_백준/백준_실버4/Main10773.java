package 자바_백준.백준_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int ans = 0;

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i<num; i++){
            int n = Integer.parseInt(br.readLine());
            if(n != 0){
                st.push(n);
            }else{
                st.pop();
            }
        }

        while(!st.isEmpty()){
            ans += st.pop();
        }
        System.out.println(ans);
    }
}
