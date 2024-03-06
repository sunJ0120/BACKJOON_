package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
"dz=" 랑 "z="구분법을 모르겠음.
 */
public class main_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String str2 = str;
        int count = 0;

        String[] chroa = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};


        for(int i = 0; i< chroa.length; i++){
            if(str.contains(chroa[i])){
                count += ((str.length() - (str.replace(chroa[i], "")).length()) / chroa[i].length());
                str2 = str2.replace(chroa[i], ""); //전부다 바꾸고 남은것
            }
        }

        count += str2.length();

        System.out.println(count);
    }
}
