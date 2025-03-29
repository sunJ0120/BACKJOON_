package 자바_백준.백준_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;
        char[] ch = br.readLine().toCharArray();
        char[] ans = new char[ch.length];

        Arrays.sort(ch);

        Queue<Character> que = new ArrayDeque<>();

        for(char c : ch){
            que.add(c);
        }

        int start = 0;
        int end = ans.length-1;

        int cnt = 0; //이동수인데, 펠린드롬은 위로 올라가는게 최대 한 번 더 + 이므로 +1을 넘을 수 없음

        while(!que.isEmpty()){

            if(cnt > ch.length+1){
                flag = false;
                break;
            }

            char a = que.poll();

            if(start!=end){ //가운데가 아님
                if(que.peek() == a){ //같은 수
                    ans[start++] = a;
                    ans[end--] = que.poll();
                    cnt += 2;
                }else{
                    que.offer(a);
                    cnt += 1;
                }
            }else{
                ans[start] = a;
                cnt += 1;
            }
        }
        if(!flag){
            System.out.println("I'm Sorry Hansoo");
        }else{
            System.out.println(ans);
        }
    }
}
