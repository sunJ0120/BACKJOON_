package 자바_백준.백준_실버3;

import java.io.*;
import java.util.*;

public class Main2108 {

    static int[] ox;
    static int[] li;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ox = new int[8000+1];
        li = new int[n];

        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            li[i] = num;
            ox[num+4000]++; //최빈값 구하기 위함
        }

        Arrays.sort(li);

        bw.write(mean(n) +"\n");
        bw.write(median(n) +"\n");
        bw.write(mode() +"\n");
        bw.write(scope(n) +"\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int mean(int n){ //전체 크기
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += li[i];
        }

        return Math.round(sum/(float) n);
    }

    public static int median(int n){ //전체 크기
        return li[n/2];
    }

    public static int mode(){
        int max = 0;
        List<Integer> li = new ArrayList<>(); //여러개 저장하기 위함

        for(int x : ox){
            max = Math.max(max,x);
        }

        for(int i = 0; i<ox.length; i++){
            if(ox[i] == max){
                li.add(i);
            }
            if(li.size() > 2){ //두번째로 작은수만 있으면 되므로
                break;
            }
        }

        if(li.size() == 1){ //하나만 존재
            return li.get(0) - 4000;
        }else{
            return li.get(1) - 4000;
        }
    }

    public static int scope(int n){ //범위
        return li[n-1] - li[0];
    }
}
