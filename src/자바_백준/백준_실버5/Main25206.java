package 자바_백준.백준_실버5;

import java.io.*;
import java.util.*;
public class Main25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double cnt = 0;
        double sum = 0;

        StringTokenizer st;

        Map<String,Double> map = new HashMap<>();

        map.put("A+", 4.5);map.put("A0", 4.0);map.put("B+", 3.5);map.put("B0", 3.0);
        map.put("C+", 2.5);map.put("C0", 2.0);map.put("D+", 1.5);map.put("D0", 1.0);map.put("F", 0.0);

        for(int i = 0; i<20; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double num = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if(!grade.equals("P")){
                cnt += num;
                sum += (num * map.get(grade));
            }
        }

        double ans = sum/cnt;

        System.out.printf("%.6f\n", ans); //이거 표기법 잘 알아두기
    }
}
