package 자바_백준.백준_브론즈2;

import java.io.*;
import java.util.Arrays;

public class main_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] alpha = br.readLine().toCharArray();

        int[] ansList = new int[26];
        Arrays.fill(ansList, -1); //초기화

        for(int i = 0; i<alpha.length; i++){
            if(ansList[alpha[i] - 'a'] == -1) { //처음 나오는 것이므로
                ansList[alpha[i] - 'a'] = i;
            }
        }

        for(int i = 0; i<ansList.length; i++){
            bw.write(ansList[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
