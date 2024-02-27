package 자바_백준.백준_실버5;

/*
1. 알파벳을 의미하는 배열을 둔다 = 26개의 boolean 배열
2. 알파벳이 연속으로 같은것이 나올때는 false 그대로 둔다.
3. 다른 알파벳이 나오면 이전 것을 true로 바꾼다.
4. 다음에 나온 알파벳이 바꾸려고 하는데 true일 경우, 이미 한번 체크가 끝난 것이므로 그룹 단어가 아니다. (count를 뺀다.)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class main_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count = n;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            boolean[] words = new boolean[26];
            for(int j = 1; j < str.length(); j++){
                if((str.charAt(j-1) - 'a') != (str.charAt(j) - 'a')){
                    words[str.charAt(j-1) - 'a'] = true;
                }
                if(words[str.charAt(j) - 'a'] == true){
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
