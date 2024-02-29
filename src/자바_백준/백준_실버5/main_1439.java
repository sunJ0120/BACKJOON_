package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.min;

/*
이거 같은 경우는, 결국 0과 1중 어떤 것을 뒤집을지에 대한 문제이다.
1. 0 -> 1로 바뀌는 구간의 개수를 구한다. (0을 뒤집는 경우)
2. 1 -> 0으로 바뀌눈 구간의 개수를 구한다. (1을 뒤집는 경우)

두가지 경우를 비교해서 어떤 것을 뒤집는것이 최소인지를 구한다.
* 마지막은 무조건 추가해야 한다는 개념을 이해하는 것이 중요하다.

 */
public class main_1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] card = str.toCharArray();

        int one = 0;
        int zero = 0;

        for (int i = 1; i < card.length; i++) {
            if(card[i-1] != card[i]){ //바뀌었다.
                if(card[i-1] == '0'){ //이전값 기준
                    zero++; //0을 뒤집는다.
                }else{
                    one++;
                }
            }

            if(i == card.length-1){ //!마지막은 무조건 추가
                if(card[i] == '0'){
                    zero++;
                }else{
                    one++;
                }
            }
        }
        System.out.println(min(one,zero));
    }
}
