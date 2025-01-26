package 자바_백준.백준_브론즈2;

import java.io.*;
import java.util.StringTokenizer;

public class main_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String as = "12345678"; //이거 new String 객체로 감싸는 거랑 뭐가 다른지 꼭 비교해보기
        String dis = "87654321";

        StringBuilder stb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());;
        for(int i = 0; i<8; i++){
            stb.append(st.nextToken());
        }

        if(stb.toString().equals(as)){
            bw.write("ascending");
        }else if(stb.toString().equals(dis)){
            bw.write("descending");
        }else{
            bw.write("mixed");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
