package 백준_브론즈1;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/*
접근 방법은 다음과 같다.
1. 우선 최댓값을 구한다.
2. 최댓값을 이용해서 n/max * 100으로 새로운 값을 구해서 리스트에 추가한다.
3. 평균을 구해서 답을 도출한다.
4. 한가지 걸리는 부분은, 오차가 10-2 이하여야 한다는 것인데 이건 일단 무시하고 진행한다.
 */
public class main_1546 {
    public static void main(String[] args) throws IOException, NoSuchElementException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        double[] score = new double[n];
        Double sum = 0.0;

        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        Double max = Arrays.stream(score)
                .max()
                .getAsDouble();

        for (int i = 0; i < n; i++) {
            score[i] = (score[i] / max) * 100;
            sum += score[i];
        }

        bw.write(sum / n + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
