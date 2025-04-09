package 자바_백준.백준_실버5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main4673 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] li = new boolean[10001];

        for(int i = 1; i<li.length; i++){
            if(!li[i]) { //false일// 경우
                bw.write(i + "\n");
            }
            int n = i; //구하는 수
            int num = i; //나누는 수
            while(num > 0){
                n += num % 10;
                num /= 10;
            }
            if(n < 10001){
                li[n] = true;
            }
        }
        bw.flush();
        bw.close();
    }
}
