package 자바_백준.백준_실버4;

import java.io.*;
import java.util.Stack;

/*
- StackA는 )를 저장하고, StackB는 (를 저장한다.
    1. A에서 (가 나오면 B스택으로 옮기고, )가 나오면, B에 요소가 있을 경우 꺼내고 없을 경우는 짝이 없는거라 false
    2. 두 개가 다 비면 true이다.

- 변경_LIF0의 경우 거꾸로 가야 하무로
- StackA는 (를 저장하고, StackB는 )를 저장한다.
 */
public class Main9012{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int roop = Integer.parseInt(br.readLine());

        for(int i = 0; i<roop; i++){
            char[] parenthesis = br.readLine().toCharArray();

            Stack<Character> stackA = new Stack<>();
            Stack<Character> stackB = new Stack<>();

            for(char c : parenthesis){
                stackA.push(c);
            }

            boolean flag = true;
            //( 일 경우 stackB에 옮기기
            while(!(stackA.isEmpty() && stackB.isEmpty())){
                if(!stackA.isEmpty() && stackA.peek().equals(')')){ //비어 있으면 짝을 맞출수가 없어서. empty 조건 넣기
                    stackB.push(stackA.pop());
                    continue;
                }
                if(!stackA.isEmpty() && stackA.peek() == '('){
                    if(!stackB.isEmpty() && stackB.peek() == ')'){ //비어 있으면 짝을 맞출수가 없어서. empty 조건 넣기
                        stackB.pop();
                        stackA.pop();
                        continue;
                    }
                }
                flag = false; //짝 안맞으면 틀린것.
                break;
            }

            if(!flag){
                bw.write("NO" + "\n");
            }else{
                bw.write("YES"+ "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
