package 자바_백준.백준_브론즈1;

import java.io.*;

public class main_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) { //0이 나오면 끝
            String str = br.readLine();
            StringBuilder stb = new StringBuilder();
            stb.append(str);

            if(str.equals("0")){
                break;
            }
            if(str.equals(stb.reverse().toString())){ //펠린드롬수 검사
                bw.write("yes" + "\n");
            }else{
                bw.write("no" + "\n");
            }
            bw.flush();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
