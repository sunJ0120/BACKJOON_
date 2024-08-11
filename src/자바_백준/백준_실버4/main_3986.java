package 자바_백준.백준_실버4;

import java.io.*;
import java.util.Stack;

public class main_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n;i++){
            String st = br.readLine();
            char[] greatwords = st.toCharArray();
            char ch; //비교용

            Stack<Character> stk = new Stack<>();

            for(char greatword : greatwords){
                stk.add(greatword);
            }

            int cnt = 0;
            int ans = 0;

            while(!stk.empty()){
                ch = stk.pop();
                if(ch == stk.peek()){
                    stk.pop(); //하나 더 지움

                }else{
                    if(cnt > 0){
                        break;
                    }
                    cnt++; //누적 카운드
                }
            }
            if(cnt == 0){
                ans++;
            }
        }

    }
}
