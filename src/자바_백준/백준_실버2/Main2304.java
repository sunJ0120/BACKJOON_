package 자바_백준.백준_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int ans = 0;
        int[] li = new int[1001]; //1000이하니까

        int maxInd = 0;
        int maxValue = 0;
        int length = 0;

        for(int i = 0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int ind = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            //max의 인덱스를 알기 위함
            if(maxValue < value){
                maxInd = ind;
                maxValue = value;
            }

            //끝값
            if(ind > length){
                length = ind;
            }

            li[ind] = value;
        }

        //1. 일단 max까지
        for(int i = 0; i<maxInd; i++){
            if(li[i] > li[i+1]){
                li[i+1] = li[i];
            }
        }

        //2. 끝부터 max까지
        for(int i = length; i>maxInd; i--){
            if(li[i] > li[i-1]){
                li[i-1] = li[i];
            }
        }

        //3. 전부 더하기
        for(int i = 0; i<=length; i++){
            ans += li[i];
        }
        System.out.println(ans);
    }
}
