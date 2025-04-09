package 자바_백준.백준_실버4;

import java.io.*;
import java.util.Stack;

/*
이거 종료조건을 위해서
st = br.readLine();를 어떻게 해야 하는지를 모르겄네
 */

public class main_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;

        while(true){
            String st = br.readLine();

            if(st.equals(".")){
                break;
            }

            Stack<Character> sta = new Stack<>();
            char[] cha = st.toCharArray();

            for (int i = 0; i < cha.length; i++) {
                if(sta.empty()){
                    /*
                    ')' || cha[i] == ']' 처음에 이게 오는경우, 이것만 오는 경우에 stack이 비면 안됨
                    또한, 이게 stack에 짝으로 들어 있는 경우 어짜피 균형 단어가 안되므로 옳다.
                     */

                    if(cha[i] == '(' || cha[i] == '['||cha[i] == ')' || cha[i] == ']'){
                        sta.push(cha[i]);
                    }
                }else{
                    if ((sta.peek() == '(')&&(cha[i] == ')')) {
                        sta.pop();
                    }else if((sta.peek() == '[')&&(cha[i] == ']')){
                        sta.pop();
                    }else {
                        if((cha[i] == '[')||(cha[i] == ']')||(cha[i] == '(')||(cha[i] == ')')){
                            sta.push(cha[i]);
                        }
                    }
                }
            }
            if(sta.empty()){
                bw.write("yes\n");
            }else{
                bw.write("no\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
