package 자바_백준.백준_실버4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Collections.sort;

public class main_1920_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        List<Integer> numList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }

        sort(numList);

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            bw.write(binarySort(Integer.parseInt(st.nextToken()), numList) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    public static int binarySort(int num, List<Integer> numList){

        int startIndex = 0;
        int endIndex = numList.size() - 1;
        int halfIndex;
        int ans = 0;

        while(startIndex <= endIndex){
            halfIndex = startIndex + (endIndex - startIndex)/2;

            if(numList.get(halfIndex) == num){
                ans = 1;
                break;
            }else{
                if(numList.get(halfIndex) > num){
                    endIndex = halfIndex - 1;
                }else if (numList.get(halfIndex) < num){
                    startIndex = halfIndex + 1;
                }
            }
        }
        return ans;
    }
}
