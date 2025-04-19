package 자바_백준.백준_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
디버깅 과정
1. 처음에 beforeInd로 잡았더니 레이저여도 올라가는 상태가 생겨서
afterind로 잡고 ind값인 a를 올리기로.
2. afterind이므로, ind < ch.length 이 부분 0이 추가된 리스트 까지가 아니라 ind < str.length()이렇게 문장 까지만 가는게 맞음..
- while 문 조건이 상당히 헷갈리니 주의하자. (이게 아니면 afterind가 넘어감.)
 */
public class Main10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<>();
        int cnt = 0;

        String str = br.readLine();
        char[] ch = new char[str.length()+1];

        for(int i = 0; i<str.length(); i++){
            ch[i] = str.charAt(i);
        }
        ch[str.length()] = '0';

        int ind = 0;
        int afterInd = ind+1;

        while(ind < str.length()){
            char a = ch[ind];
            char b = ch[afterInd];
            if(isLaser(a,b)){
                cnt += st.size();
                ind = afterInd+1; //b까지 없어진 셈이라.
                afterInd = ind+1;
            }else{
                if(!st.isEmpty() && (st.peek() == '(' && a == ')')){
                    st.pop();
                    cnt++;
                    ind++;
                    afterInd = ind+1;
                }else{
                    st.push(a);
                    ind++;
                    afterInd = ind+1;
                }
            }
        }
        System.out.println(cnt);
    }

    public static boolean isLaser(char a,char b){
        if(a == '(' && b == ')'){
            return true;
        }
        return false;
    }
}
