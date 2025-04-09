package 자바_백준.백준_브론즈2;

import java.io.*;

public class main_5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] ch = br.readLine().toCharArray();
        int ans = 0;

        for(int i = 0; i<ch.length; i++){
            switch (ch[i]){
                case 'A' : case 'B' : case 'C' :
                    ans += 3;
                    break;
                case 'D' : case 'E' : case 'F' :
                    ans += 4;
                    break;
                case 'G' : case 'H' : case 'I' :
                    ans += 5;
                    break;
                case 'J' : case 'K' : case 'L' :
                    ans += 6;
                    break;
                case 'M' : case 'N' : case 'O' :
                    ans += 7;
                    break;
                case 'P' : case 'Q' : case 'R' : case 'S' :
                    ans += 8;
                    break;
                case 'T' : case 'U' : case 'V' :
                    ans += 9;
                    break;
                case 'W' : case 'X' : case 'Y' : case 'Z' :
                    ans += 10;
                    break;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
