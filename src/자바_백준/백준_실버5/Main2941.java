package 자바_백준.백준_실버5;

import java.io.*;

public class Main2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String st = br.readLine();

        String[] li = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        int ans = 0;

        for (int i = 0; i < li.length; i++) {
            while (st.contains(li[i])) {  // 해당 문자열이 존재할 경우 반복해서 치환
                ans++;
                st = st.replaceFirst(li[i], "*"); // replaceFirst를 사용하여 한 번만 변경
            }
        }

        for(int i = 0; i<st.length(); i++){
            if(st.charAt(i) != '*'){
                ans++;
            }
        }

        System.out.println(ans);
        br.close();
    }
}

