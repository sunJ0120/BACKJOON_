package 자바_백준.백준_실버3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String regex = "(?=<)|(?<=>)"; //<>기준으로 자르는 정규식
        String[] st = br.readLine().split(regex);

        List<String> li = new ArrayList<>();

        for(String a : st) {
            if (!a.contains("<")) { //태그없
                String[] stt = a.split(" ");
                for(int j = 0; j<stt.length; j++){
                    StringBuilder stb = new StringBuilder();
                    stb.append(stt[j]);
                    stb.reverse(); //뒤집기
                    if(j < stt.length-1){ //마지막이 아닌 경우만
                        stb.append(" "); //원래 있었던 구분자 더하기
                    }
                    li.add(stb.toString());
                }
            } else {
                li.add(a);
            }
        }

        for(String ans : li){ //합치기
            bw.write(ans + "");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
