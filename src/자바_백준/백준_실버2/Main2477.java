package 자바_백준.백준_실버2;

import java.io.*;
import java.util.*;

public class Main2477 {

    static int hex = 6;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int big = 1; //큰 넓이
        int small = 1; //작은 넓이

        int[] size = new int[hex];
        int[] direct = new int[hex];
        int[] checkDirect = new int[5];
        Set<Integer> dualDirect = new HashSet<>();

        StringTokenizer st;

        //배열 생성
        for(int i = 0; i<hex; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            direct[i] = d;
            checkDirect[d]++; //direct 개수 증가
            size[i] = s;
            if(checkDirect[d] == 2){
                dualDirect.add(d);
            }
        }
        //큰 넓이
        for(int i = 0; i<hex; i++){
           if(!dualDirect.contains(direct[i])){
               big *= size[i];
           }
        }

        int cnt = 0;
        int ind = 0;
        boolean flag = false;

        while(!flag){ //방향 바뀌는 시점 찾기
            if(!dualDirect.contains(direct[ind%hex]) && dualDirect.contains(direct[(ind+1)%hex])){ //방향 바뀌는 시점일때
                flag = true;
            }
            ind++; //인덱스 이동
        }

        //작은 넓이 찾기
        while(cnt < 4){
            //count 늘리기
            if(flag && dualDirect.contains(direct[ind%hex])) {
                cnt++;
            }
            if(cnt == 2|| cnt == 3){
                small *= size[ind%hex];
            }
            ind++; //인덱스 이동
        }
        System.out.println(num * (big-small));
    }
}
