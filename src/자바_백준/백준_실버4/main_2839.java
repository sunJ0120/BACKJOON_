package 자바_백준.백준_실버4;

import java.io.*;

/*
5로 먼저 나눈다
나머지가 3으로 나눠 지는지 확인

3으로 나눈다
나눠지지 않으면 -1
 */
public class main_2839 {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int five_sha = num / 5;
        int three_sha = num / 3;

        int ans = 0;

        if(num % 5 == 0){
            ans = five_sha;
        }else{
            int three_sh = 1;

            while((5 * (five_sha)>0) && ((num - (5 * (five_sha))) %3 != 0)){
                three_sh++; //3하나 증가
                five_sha--; //5하나 감소
            }

            if(five_sha == 0){ //5가 없음
                if(num % 3 == 0){
                    ans = three_sha;
                }else{
                    ans = -1; //나눌 수 없음
                }
            }else{ //5가 하나라도 있고 끝났으므로, 값이 있음
                ans += five_sha;
                ans += three_sh;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
