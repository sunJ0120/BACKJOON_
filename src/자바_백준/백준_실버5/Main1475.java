package 자바_백준.백준_실버5;

import java.io.*;

public class Main1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();
        int max = 0;
        int[] li = new int[10];

        for(int i = 0; i<ch.length; i++){
            if(ch[i]-'0' == 9||ch[i]-'0' == 6){
                if(li[9] <= li[6]){
                    li[9]++;
                }else{
                    li[6]++;
                }
            }else{
                li[ch[i]-'0']++;
            }
        }

        for(int i = 0; i<li.length;i++){
            max = Math.max(max, li[i]);
        }
        System.out.println(max);
    }
}
