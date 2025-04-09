package 자바_백준.백준_브론즈2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main_2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();

        for(int i =0; i<5; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        int sum = 0;

        for(int a : list){
            sum += a;
        }

        bw.write(sum/5 + "\n"); //평균
        bw.write(list.get(2) + "\n"); //중앙값
        bw.close();
        br.close();
    }
}
