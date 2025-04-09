package 자바_백준.백준_브론즈1;

import java.io.*;

public class main_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] ch = br.readLine().toCharArray();

        for (int i = 0; i < ch.length; i++) {
            int n = (int) ch[i] + 13;

            if(65 <= (int) ch[i] && (int) ch[i] <= 90){ //char ascii로 변경하려면 명시적 형변환을 하면 됨다.
                if(n > 90){
                    ch[i] = (char) (n-90 + 64); //예를 들어 91이다 이러면 A여야 하므로, 65가 아니라 64를 더해줘야ㅓ 한다.
                }else{
                    ch[i] = (char) n;
                }
            }else if(97 <= (int) ch[i] && (int) ch[i] <= 122){
                if(n > 122){
                    ch[i] = (char) (n-122 + 96);
                }else{
                    ch[i] = (char) n;
                }
            }
        }

        bw.write(new String(ch) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
