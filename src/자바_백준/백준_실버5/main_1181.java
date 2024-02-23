package 자바_백준.백준_실버5;

/*
Arrays.sort의 Comparator를 재정의 하는 방법으로 해결한다.
재정의 하는 방법은 블로그를 참조

내일은 이유까지 상세하게 정리해두기
 */
import java.io.*;
import java.util.*;

public class main_1181 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];

        //주어진 단어들 전부 넣기
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        //정렬
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String str1, String str2){ //-1, 0, 1
                if(str1.length() == str2.length()){
                    return str1.compareTo(str2);
                }else{
                    return str1.length() - str2.length();
                }
            }
        });

        //중복제거
        for (int i = 1; i < n; i++) {
            if(!str[i].equals(str[i-1])){
                bw.write(str[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
