package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1차 풀이 계획
크로아티아 알파벳에 해당하는 것을 리스트로 만들어 둔다
countChar를 이용해서 반복문을 돌면서 몇개인지를 구한다.
 */
public class main_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int count = 0;

        String[] chroa = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(int i = 0; i< chroa.length; i++){
            if(str.contains(chroa[i])){ //분리해야함. 값이 누적된다.
                count += (str.length() - str.replace(chroa[i],"").length()); //이 방법 알아두기
            }
        }

        System.out.println(count);
    }
}
