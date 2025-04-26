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
        char[] sentence = br.readLine().toCharArray();
        Double[] number = new Double[roop];

        Stack<Double> sta = new Stack<>();

        for(int i = 0; i<roop; i++){
            number[i] = Double.parseDouble(br.readLine());
        }

        for(int i = 0; i<sentence.length; i++){
            if('A' <= sentence[i] && sentence[i] <= 'Z'){
                sta.push(number[sentence[i]-'A']);
            }else{
                double a = sta.pop();
                double b = sta.pop();

                if(sentence[i] == '*'){
                    sta.push(a*b);
                }else if(sentence[i] == '+'){
                    sta.push(a+b);
                }else if(sentence[i] == '-'){
                    sta.push(b-a);
                }else{
                    sta.push(b/a);
                }
            }
        }
        double ans = sta.pop();
        System.out.printf("%.2f\n", ans);
        br.close();
    }
}
