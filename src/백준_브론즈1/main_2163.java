package 백준_브론즈1;

import java.io.*;

public class main_2163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int ans = n;
        int num = 0;

        do{
            int sum;
            sum = ans / 10 + ans % 10;
            ans = (ans % 10) * 10 + (sum % 10);
            num++;
        }while(n != ans);

        bw.write(num + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
