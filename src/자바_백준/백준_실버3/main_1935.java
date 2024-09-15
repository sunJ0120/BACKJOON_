package 자바_백준.백준_실버3;

import java.io.*;
import java.util.Stack;

public class main_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        char[] back = br.readLine().toCharArray();
        double[] number = new double[num];

        Stack<Double> st = new Stack<>();

        for (int i = 0; i < num; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        for (int j = 0; j < back.length; j++) {
            if ('A' <= back[j] && back[j] <= 'Z') { //알파벳
                st.push(number[back[j] - 65]);
            }else{ //기호
                double b = st.pop(); //LIFO. 순위 주의
                double a = st.pop();

                if(back[j] == '+'){
                    st.push(a+b);
                }else if(back[j] == '-'){
                    st.push(a-b);
                }else if(back[j] == '*'){
                    st.push(a*b);
                }else{
                    st.push(a/b);
                }
            }
        }

        System.out.printf("%.2f",st.pop()); //표기 주의
        br.close();

    }
}
