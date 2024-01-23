package 백준_브론즈5;
import java.io.*;

/**
 * 첫번째 풀이는 char 배열로 변경한 뒤 아스키 코드를 이용해서
 * 소문자이면 + 32로 대문자로, 반대면 -32로 소문자로 바꾸는 방법을 이용
 *
 * 문제점은 : 굳이 배열을 사용해야 하느냐?
 * 아스키 코드를 사용하는 것이 맞느냐 하는 문제가 있었음
 */

public class main_2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        char[] arr = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i); //배열로 옮겨서 배열로 만들기
        }

        //변환
        for (int i = 0; i < str.length(); i++) {
            if (arr[i] < 97) { //소문자
                arr[i] += 32; //대문자로
            } else {
                arr[i] -= 32; //소문자로
            }
        }

        //출력
        for (int i = 0; i < str.length(); i++) {
            bw.write(arr[i]);
        }
        bw.write("\n");

        br.close();
        bw.flush();
        br.close();
    }
}

