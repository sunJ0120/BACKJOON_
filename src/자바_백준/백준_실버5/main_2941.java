package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
알파벳이 겹치지 않게 하려면, 알파벳에 걸리지 않는 수로 바꿔주면 된다.
 */
public class main_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int count = 0;

        String[] chroa = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(int i = 0; i< chroa.length; i++){
            if(str.contains(chroa[i])){
                str = str.replace(chroa[i], "!");
            }
        }

        count += str.length();
        System.out.println(count);
    }
}
