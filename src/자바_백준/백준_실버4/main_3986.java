package 자바_백준.백준_실버4;

import java.io.*;
import java.util.Stack;

public class main_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 0; i<n;i++){
            String st = br.readLine();
            char[] greatwords = st.toCharArray();
            //stack 생성
            Stack<Character> stk = new Stack<>();

            for(int j = 0; j<greatwords.length; j++){
                if (stk.empty()) {
                    stk.push(greatwords[j]);
                }else{ //stack 비지 않았음
                    if(stk.peek() == greatwords[j]){
                        stk.pop(); //하나 지우기
                    }else{
                        stk.push(greatwords[j]);
                    }
                }
            }

            if(stk.empty()){
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
