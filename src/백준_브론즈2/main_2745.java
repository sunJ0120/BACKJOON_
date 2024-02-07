package 백준_브론즈2;

import java.io.*;
import java.util.StringTokenizer;

/*
내가 너무 어렵게 접근했다 처음에...
1. char로 쪼개고
2. A의 경우는 65부터 시작이므로, 숫자로 바꾸려면 -55를 해주면 된다.
3. 즉, 굳이 배열을 만들어 접근할 필요가 없다.

-'0'에 대해 잘못 이해하고 있었음

-'0'을 해주면 숫자로 바뀌눈 것은
0이 아스키에서 48이기 때문에
그걸 빼면 숫자 0이 나오기 때문이다.

그런데 A이런애들은, 90이니까
-'0'을 빼면 42 이런식으로 나오겠지.
그러니까 원하던 숫자값으로 나오지 않는 것이다!!
 */
public class main_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String str = st.nextToken();
        int digit = Integer.parseInt(st.nextToken());
        int ans = 0;

        for(int i = 0; i<= str.length()-1;i++){
            char c = str.charAt(i);
            int num;
            if('0'<=c && c<='9'){ //0~9
                num = c - '0';

            }else{
                num = c - 55;
            }
            ans += (Math.pow(digit, str.length() - 1 - i) * num);
        }

        bw.write(ans + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
