package 백준_브론즈5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//Map을 이용해서 key-value 값을 짝지어서 해결해보자.
public class main_2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, String> score = new HashMap<>();

        //학점 정보 넣기
        score.put("A+", "4.3");
        score.put("A0", "4.0");
        score.put("A-", "3.7");
        score.put("B+", "3.3");
        score.put("B0", "3.0");
        score.put("B-", "2.7");
        score.put("C+", "2.3");
        score.put("C0", "2.0");
        score.put("C-", "1.7");
        score.put("D+", "1.3");
        score.put("D0", "1.0");
        score.put("D-", "0.7");
        score.put("F", "0.0");

        bw.write(score.get(br.readLine()) + "\n");
        br.close();
        bw.flush();
        bw.close();

    }
}
