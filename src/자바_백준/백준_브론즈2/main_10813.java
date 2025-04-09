package 자바_백준.백준_브론즈2;

import java.io.*;
import java.util.StringTokenizer;

public class main_10813 {
    static int[] numList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int swapInt = Integer.parseInt(st.nextToken());

        numList = new int[num];

        for(int i = 0; i<num; i++){ //바구니
            numList[i] = i+1;
        }

        for(int i = 0; i<swapInt; i++){
            st = new StringTokenizer(br.readLine());
            swap(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i<num; i++){ //바구니
            bw.write(numList[i] + " ");
        }
        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void swap(int a, int b){
        int n = numList[a-1];
        numList[a-1] = numList[b-1];
        numList[b-1] = n;
    }

}
