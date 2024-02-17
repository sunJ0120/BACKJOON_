package 자바_백준.백준_실버5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
정렬하기 문제
기본적으로, 자바에는 arrays.sort가 있지 않나?
이것말고 다른것을 사용하라는 의미인지는 모르겠지만, 일단 이걸 사용해보자.
 */
public class main_2751
{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> nlist = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            nlist.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(nlist);
        for (int i = 0; i < n; i++) {
            bw.write(nlist.get(i) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
