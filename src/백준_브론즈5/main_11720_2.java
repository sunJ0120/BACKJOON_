package 백준_브론즈5;

import java.io.*;

public class main_11720_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        String str = br.readLine();
        int[] ansList = new int[n];

        //charAt으로 char로 변경하고 '0'을 빼서 숫자로 만드는 방법
        for(int i = 0; i< n; i++){
            ansList[i] = str.charAt(i) - '0';
            ans += ansList[i];
        }

        bw.write(ans + "\n");
        br.close();
        bw.flush();
        br.close();
    }
}
