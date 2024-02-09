package 백준_브론즈1;

import java.io.*;
import java.util.Arrays;

/*
접근 방법
1. toUpperClass or toLowerClass를 통해 문자를 통일한다.
2. 25개의 리스트를 만든다.(알파벳에 해당)
3. 대문자로 할 경우, A = 65이므로, 65씩 빼서 A를 기준으로 잡는다.
4. 각각 나온만큼 리스트에 수를 더하고, 가장 빈도가 많은 알파벳이 무엇인지 구한다.
5. 알파벳을 구할때는 + 65를 통해 다시 대문자로 복원해서 출력한다.
 */
public class main_1157 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        str = str.toUpperCase();
        int max = 0;
        int maxIndex = 0;
        boolean same = false;

        int[] alpha = new int[25+1];
        Arrays.fill(alpha,0);

        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i)-65]++;
        }
        for(int i = 0; i<=25;i++){
            if(alpha[i] > max){
                max = alpha[i];
                maxIndex = i;
                same = false; //같지 않음, 즉 하나라도 홀로 큰 값이 있음
            }else if(alpha[i] == max){ //같을 경우, same 파라미터 변경
                same = true;
            }
        }

        if(same){
            bw.write("?" + "\n");
        }else{
            char c = (char) (maxIndex + 65);
            bw.write( c +"\n");
        }

        br.close();
        bw.flush();
        bw.close();

    }
}
