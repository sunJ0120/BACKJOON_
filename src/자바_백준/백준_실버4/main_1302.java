package 자바_백준.백준_실버4;

/*
포인트는...

1. 이름으로 map 생성
2. 횟수 구해서 value로 생성
 */

import java.io.*;
import java.util.*;

public class main_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        Map<String, Integer> books = new HashMap<>(); //map 생성

        for(int i = 0; i<num ; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if(!books.containsKey(name)){ //없으면 생성
                books.put(name,1);
            }else{ //있으면 숫자 증가
                books.replace(name,books.get(name)+1);
            }
        }
        // keySet을 리스트로 변환하여 정렬
        List<String> keyList = new ArrayList<>(books.keySet());
        Collections.sort(keyList); //Collection으로 정렬할때는 가변 리스트여야 한다.

        int maxValue = 0;
        String maxString = "";

        for(int i = 0; i<keyList.size(); i++){
            if(books.get(keyList.get(i)) > maxValue){
                maxValue = books.get(keyList.get(i));
                maxString = keyList.get(i);
            }else{
                continue;
            }
        }

        bw.write(maxString);
        bw.flush();
        br.close();
        bw.close();

    }
}
