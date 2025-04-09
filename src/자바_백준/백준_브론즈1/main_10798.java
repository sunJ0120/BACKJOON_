package 자바_백준.백준_브론즈1;

import java.io.*;
import java.util.Arrays;

public class main_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] li = new char[5][15];
        int max = 0;

        for (int i = 0; i < 5; i++) { //* 초기화 하는 방법 정리하기.
            Arrays.fill(li[i], '*');
        }

        for(int i = 0; i<5; i++){ //5줄
            char[] ch = br.readLine().toCharArray(); //*여기 아예 바뀐다는 것 주의
            if(max < ch.length){
                max = ch.length;
            }
            for(int j = 0; j<ch.length; j++){
                li[i][j] = ch[j];
            }
        }

        for(int i = 0; i<max; i++){
            for(int j = 0; j<5; j++){
                if(li[j][i] != '*'){
                    bw.write(li[j][i]);
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
