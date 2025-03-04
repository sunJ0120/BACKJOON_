package 자바_백준.백준_브론즈2;

import java.io.*;

public class main_10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String st = br.readLine();
            if(st == null){ //입력이 없을 경우
                break;
            }
            char[] ch = st.toCharArray();

            int a = 0; //소문자
            int b = 0; //대문자
            int c = 0; //숫자
            int d = 0; //공백

            for(int i = 0; i<ch.length; i++){
                if('a' <= ch[i] && ch[i] <= 'z'){
                    a++;
                }else if('A' <= ch[i] && ch[i] <= 'Z'){
                    b++;
                }else if('0' <= ch[i] && ch[i] <= '9'){
                    c++;
                }else{
                    d++;
                }
            }
            bw.write(a + " " + b + " " + c + " " + d + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
