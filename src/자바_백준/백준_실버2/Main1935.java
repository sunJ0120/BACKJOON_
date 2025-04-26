package 자바_백준.백준_실버2;

import java.io.*;
import java.util.Stack;
/*
STACK = DOUBLE이어도 상관 없음!
 */
public class Main1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int roop = Integer.parseInt(br.readLine());
        char[] senten = br.readLine().toCharArray();
        String[] sentence = new String[senten.length];
        for(int i = 0; i<senten.length; i++){
            sentence[i] = String.valueOf(senten[i]);
        }

        Stack<Double> sta = new Stack<>();

        String[] num = new String[roop];

        for(int i = 0; i<roop; i++){
            num[i] = br.readLine();
        }

        //정규표현식 [A-Z]
        String pattern = "[A-Z]";
        //숫자 넣기
        for(int i = 0; i<sentence.length; i++){
            if(sentence[i].matches(pattern)){
                sentence[i] = num[sentence[i].toCharArray()[0]-'A'];
            }
        }

        for(int i = 0; i<sentence.length; i++){
            if(!sentence[i].equals("*") && !sentence[i].equals("+") && !sentence[i].equals("-")&& !sentence[i].equals("/")){
                sta.push(Double.parseDouble(sentence[i]));
            }

            if(sentence[i].equals("*")){
                double a = sta.pop();
                double b = sta.pop();
                sta.push(a*b);
            }

            if(sentence[i].equals("+")){
                double a = sta.pop();
                double b = sta.pop();
                sta.push(a+b);
            }

            if(sentence[i].equals("-")){
                double a = sta.pop();
                double b = sta.pop();
                sta.push(b-a);
            }

            if(sentence[i].equals("/")){
                double a = sta.pop();
                double b = sta.pop();
                sta.push(b/a);
            }
        }

        double ans = sta.pop();
        System.out.printf("%.2f\n", ans); //표현식 주의
    }
}
