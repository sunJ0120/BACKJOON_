package 자바_백준.백준_실버5;

import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
/*
string으로 받아서 int로 변환해서 비교하는 방법을 사용해야 할듯
일단 받아서 char 배열로 변환이 가능한지를 보자.
 */
public class main_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] str = br.readLine().toCharArray();

        Arrays.sort(str);

        for(int i = str.length-1; i>= 0; i--){ //굳이 내림차순 정렬할 필요 없이 꺼꾸로 보면 된다.
            bw.write(str[i]);
        }
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
