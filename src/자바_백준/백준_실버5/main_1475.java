package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
포인트는 9와 6은 뒤집어서 사용할 수 있다는 것 같은데..
일단 인덱스를 만들어 두고, 9와 6은 이미 존재하면 분배가 가능한걸로 만들어두고
뽑을때 max로 뽑으면 뽑아낼 수 있을 것 같다.
 */
public class main_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] number = new int[10];

        String str = br.readLine();

        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) - '0' == 6 && number[str.charAt(i) - '0'] > number[9]){ //6인데 이미 수가 있음
                number[9]++;
                continue;
            }

            if(str.charAt(i) - '0' == 9 && number[str.charAt(i) - '0'] > number[6]){ //9인데 이미 수가 있음
                number[6]++;
                continue;
            }
            number[str.charAt(i) - '0']++;
        }

        System.out.println(Arrays.stream(number).max().getAsInt());
    }
}
