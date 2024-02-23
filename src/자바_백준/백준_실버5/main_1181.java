package 자바_백준.백준_실버5;

/*
길이가 짧은것부터 정렬
짧으면 사전순으로

이거 재정의하면 될 것 같긴한데..
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class main_1181 {

    public static int num = 0;
    public static List<String> numList = new ArrayList<String>(num);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        num = n;

        for(int i = 0; i<n;i++){
            String str = br.readLine();
            numList.add(str);
        }

        Collections.sort(numList);

        System.out.println(numList);
    }
}
