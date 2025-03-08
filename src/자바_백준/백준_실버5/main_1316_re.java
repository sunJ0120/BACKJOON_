package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main_1316_re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = 0;

        for(int i = 0; i<n; i++){
            int[] alpa = new int[26];
            char[] ch = br.readLine().toCharArray();

            int fal = 0;
            int pre = 0;

            for(int j = 0; j<ch.length; j++){
                if(alpa[ch[j] - 'a'] == 0){ //체크된 적 없음
                    alpa[ch[j] - 'a'] = 1;
                    pre = ch[j] - 'a';
                }else{
                    if(pre != ch[j] - 'a') { //이전이랑 같지 않음
                        fal = 1;
                        break;
                    }
                }
            }

            if(fal == 0){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
