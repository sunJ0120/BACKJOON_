package 자바_백준.백준_실버4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
한수의 정의
각 자리의 숫자가 등차수열을 이루면 된다.

예를 들어서,
1234 = 한수이다.
2468 = 한수이다.
2368 = 한수가 아니다.

여기서 한자리~두자리 자연수의 경우는 전부 수열로 친다.(1~99)
110 = 100 101 102 103 104...전부 x이기 때문에 99개인 것이다.

전부 다 확인해 보되, charArray로 자른 뒤에 -'0'을 해서 숫자로 바꾼다.
그 다음에 첫항과 둘째항의 차를 저장한다
그 차이만큼 계속 차이가 나고, 통과하면 끝이다.
 */
public class main_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(str);
        int ans = 0;
        int num;

        char[] digit;

        if(n <= 99){
            ans += n;
        }else{
            ans += 99; //99는 기본으로 더하고 시작한다.
            num = 100; //99부터 시작

            while(n >= num){
                String strNum = (num + "");
                digit = strNum.toCharArray(); //자릿수 쪼개기

                int tole = (digit[0] -'0') - (digit[1] -'0'); //공차
                boolean tf = true;

                for (int i = 2; i < strNum.length(); i++) {
                    if(((digit[i-1] -'0') - (digit[i] -'0')) == tole){
                        tf = true;
                    }else{
                        tf = false;
                        break;
                    }
                }
                if(tf){ //true일 경우 등차수열 만족
                    ans += 1;
                }
                num++; //하나더
            }
        }

        System.out.println(ans);
    }
}
