package 백준_브론즈5;
import java.io.*;

/**
 * 다른풀이 방법으로 한 번더 풀이
 * Character class에 포함되어 있는 toLowerCase()와 toUpperCase()를 이용
 */
public class main_2744 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder stb = new StringBuilder();
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isUpperCase(c)){ //대문자 -> 소문자
                c = Character.toLowerCase(c); //변수로 저장해야함
            }else{
                c = Character.toUpperCase(c); //소문자 -> 대문자
            }
            stb.append(c);
        }

        bw.write(stb + "\n");
        br.close();
        bw.flush();
        bw.close();

    }
}

