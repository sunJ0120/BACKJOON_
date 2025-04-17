package 자바_백준.백준_실버2;

import java.io.*;
import java.util.*;

/*
⭐ 기본 아이디어 : 최댓값 이후에 내림차순이 아니면 false

구현
    1. 임시 스택을 만들어서, 숫자를 내림차순으로 넣는다.
    2. 숫자가 더 작다면 넣고, 더 크다면 빼고를 반복한다.
No일 경우
    * 뺄때 다른수면 no다.
 */
public class Main1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int roop = Integer.parseInt(br.readLine());
        List<Integer> li = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        Stack<Integer> st2 = new Stack<>(); //임시 스택
        Stack<Integer> st1 = new Stack<>();

        boolean flag = true;

        for(int i = 0; i<roop; i++){
            int n = Integer.parseInt(br.readLine());
            li.add(n);
            st2.push(roop-i);
        }

        for(int n : li){
            //올리기
            while(!st2.isEmpty() && st2.peek() <= n){
                st1.push(st2.pop());
                ans.add("+");
            }
            if(!st1.isEmpty() && st1.peek()==n) {
                st1.pop();
                ans.add("-");
            }else if(!st1.isEmpty() && st1.peek()!=n){ //다르면 무조건 틀린것.
                System.out.println("NO");
                flag = false;
                break;
            }
        }
        if(flag){ //true라면
            for(String str : ans){
                System.out.println(str);
            }
        }
        br.close();
    }
}
