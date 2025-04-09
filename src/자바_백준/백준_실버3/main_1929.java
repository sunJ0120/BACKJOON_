package 자바_백준.백준_실버3;

import java.io.*;
import java.util.StringTokenizer;

public class main_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] ela = new boolean[end+1];

        ela[0] = true;
        ela[1] = true;
        ela[2] = false;

        for (int i = 2; i < ela.length; i++) {
            int num = 2;
            for (int j = i*2; j < ela.length; j = i * num) {
                if(ela[j] != true){ //배수 처리가 안됨
                    ela[j] = true;
                }
                num++;
            }
        }

        for(int i = start; i < ela.length; i++){
            if(ela[i] == false){
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
