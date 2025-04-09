package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1343 {
    static char[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ch = br.readLine().toCharArray();

        int a = 4;
        int b = 2;

        boolean flag = true;

        for(int i = 0; i<=ch.length-a; i++){
            if(check(i, a)){ //이 시작점에서 부터는 넣을 수 있따.
                for(int j = i; j<i+a; j++){ //바꿔주기
                    ch[j] = 'A';
                }
            }
        }

        for(int i = 0; i<=ch.length-b; i++){ //BB검사할꺼라 2칸씩 뛰어넘기
            if(check(i, b)){ //넣을 수 있따.
                for(int j = i; j<i+b; j++){ //바꿔주기
                    ch[j] = 'B';
                }
            }
        }
        //가지고 있는지 검사
        for (char c : ch) {
            if(c == 'X'){ //다 덮지 못함
                flag = false;
                break;
            }
        }

        if(flag){
            System.out.println(new String(ch));
        }else{
            System.out.println(-1);
        }
    }

    public static boolean check(int start, int num){ //더해지는 수를 넣느낟.
        for(int i = start; i<start+num; i++){
            if(ch[i] != 'X'){ //넣을 수 없음
                return false;
            }
        }
        return true;
    }
}
