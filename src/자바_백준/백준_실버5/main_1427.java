package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
/*
string으로 받아서 int로 변환해서 비교하는 방법을 사용해야 할듯
일단 받아서 char 배열로 변환이 가능한지를 보자.
 */
public class main_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder stb = new StringBuilder();
        char[] str = br.readLine().toCharArray();
        Integer[] num = new Integer[str.length];

        /*
        Integer 변경
         */
        for (int i = 0; i < str.length; i++) {
            num[i] = str[i] - '0';
        }
        Arrays.sort(num, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) { //내림차순
                return -(o1 - o2);
            }
        });

        /*
        프린트
         */
        for (int i = 0; i < num.length; i++) {
            stb.append(num[i]);
        }
        System.out.println(stb);
    }
}
