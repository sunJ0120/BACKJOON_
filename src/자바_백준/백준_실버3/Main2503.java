package 자바_백준.백준_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2025-04-10 / 저녁에 다시
 * 1. 계산 수, 범위 수가 작으므로 브루트포스로 해결한다.
 * 2. 세자리 & 전부 다른 수 이므로 123 ~ 987
 * 3. 민혁이 제시한 숫자, strike, ball로 두고, 루프를 돈다.
 *     - 이때, 기본 flag를 true로 두고, 한 단계라도 통과 못하면 그 수는 아닌 것이므로 false로 두로
 *     - 루프를 빠져나와 다음 수 (i)로 간다.
 */
public class Main2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        int cnt = Integer.parseInt(br.readLine()); //질문 수
        String[][] questions = new String[cnt][3]; //string으로 비교하는게 int보다 편할 것 같아서 일단 string으로 구현

        for(int i = 0; i<cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            questions[i][0] = st.nextToken(); //제시한 수
            questions[i][1] = st.nextToken(); //strike
            questions[i][2] = st.nextToken(); //ball
        }
        //브루트포스
        for(int i = 123; i<=987; i++){
            boolean flag = true;
            //서로 다른 세자리 숫자인지 체크
            if(!isDifferent(i)){
                continue;
            }
            String ansNum = String.valueOf(i); //정답 넘버
            for(int j = 0; j<cnt; j++){ //질문에 전부 접근
                String guessNum = questions[j][0]; //나중에 뭐가뭔지 헷갈리니까 변수로 잡고 들어가자..
                int strike = Integer.parseInt(questions[j][1]);
                int ball = Integer.parseInt(questions[j][2]);
                flag = isTrue(ansNum, guessNum, strike, ball);
                if(!flag){ //바로 해당 루프 끝내기.
                    break;
                }
            }
            if(flag){ //전부 통과
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static boolean isTrue(String ansNum, String guessNum, int strike, int ball){
        for(int i = 0; i<ansNum.length(); i++){
            if(ansNum.charAt(i) == guessNum.charAt(i)){ //같은자리 같은수
                strike--;
            }
        }
        for(int i = 0; i<ansNum.length(); i++){
            for(int j = 0; j<guessNum.length(); j++){
                if( i!=j && (ansNum.charAt(i) == guessNum.charAt(j))){ //다른자리 같은수 .charAt(i) 쓰는거인 indexOf아님..
                    ball--;
                }
            }
        }

        if(strike == 0 && ball == 0){ //둘다 맞음
            return true;
        }
        return false;
    }

    public static boolean isDifferent(int num){
        int hund = num/100;
        int ten = (num%100)/10;
        int one = num%10;

        if(hund == ten || ten == one ||hund == one){
            return false;
        }
        if(hund == 0|| ten == 0||one == 0){ //1~9이므로 0이면 안된다.
            return false;
        }
        return true;
    }
}
