package 자바_백준.백준_실버5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class main_4673 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num;
        boolean[] self = new boolean[10000+1];

        for (int i = 1; i < self.length; i++) {
            if(!self[i]){
                num = i; //시작수
                int next = i;

                while(num <= 10000){
                    do{
                        next += (num % 10); //자릿수 더하기
                        num /= 10;
                    }while(num > 0);

                    if(next <= 10000) {
                        self[next] = true;
                    }
                    num = next; //다음 num -> next 수
                }
            }
            if(!(self[i])){ //false
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
