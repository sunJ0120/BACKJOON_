package 자바_백준.백준_실버3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
이게 사실 dp보다 그냥 막가파로 하는게 더 빠를 것 같은데...
 */

public class main_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        List<Integer> toOne = new ArrayList<>();

        toOne.add(0,0);
        toOne.add(1,0);
        toOne.add(2,1);
        toOne.add(3,1);

        for (int i = 3; i <= num; i++) {
            if((i-1) % 3 == 0){ //여기가 살짝...걸림.
                toOne.add(i, toOne.get(i-1) + 1);
            }else{
                if(i % 3 == 0){
                    toOne.add(i, toOne.get(i / 3) + 1);
                }else if(i % 2 == 0){
                    toOne.add(i, toOne.get(i / 2) + 1);
                }else{
                    toOne.add(i, toOne.get(i - 1) + 1);
                }
            }
        }

        bw.write(toOne.get(num)+ "\n");
        bw.flush();
        br.close();
        bw.close();

    }
}
