package 자바_백준.백준_실버5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class main_4673 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = 1;
        boolean[] self = new boolean[10000+1];

        for (int i = 1; i < self.length; i++) {
            int next = 0;
            if(!(self[i])){ //self[i]가 false 일때만
                next += num;
                do{
                    next += (i %= 10); //자릿수 더하기
                    i /= 10;
                }while(i / 10 > 0);

                self[next] = true;

                if(!(self[i])){ //false
                    bw.write(i + "\n");
                }
            }

        }

        bw.flush();
        bw.close();
    }
}
