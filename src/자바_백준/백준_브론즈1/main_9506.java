package 자바_백준.백준_브론즈1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main_9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){ //조건 좀 맘에 안듦. 솔직히
            int n = Integer.parseInt(br.readLine());

            if(n == -1){
                break;
            }

            int[] li = new int[n/2 + 1]; //0제외
            int num = 1;
            List div = new ArrayList();

            div.add(1);

            for(int i = li.length; i> 1; i--){ //li.length / 2 x -> li.length
                if(n%i == 0 && li[i] != 1){ //약수
                    num += i;
                    num += n/i; //몫 (짝)

                    li[i] = 1;
                    li[n/i] = 1;

                    div.add(i);
                    div.add(n/i);
                }
            }

            Collections.sort(div); //정렬

            if(num == n){
                bw.write(n + " = ");
                for(int i = 0; i<div.size()-1; i++){
                    bw.write(div.get(i) + " + ");
                }
                bw.write(div.get(div.size()-1) + "\n");
            }else{
                bw.write(n + " is NOT perfect." + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
