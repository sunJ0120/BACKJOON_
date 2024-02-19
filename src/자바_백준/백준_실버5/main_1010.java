package 자바_백준.백준_실버5;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class main_1010 {
    public static BigInteger bridge(BigInteger n, BigInteger m){
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;

        if((m.subtract(n)).compareTo(n) == -1){ //m-n이 더 작다.
            n = m.subtract(n); //바꾸기
        }
        int num = n.intValue();

        for(int i = 0; i<num;i++){
            a = a.multiply(m);
            m = m.subtract(BigInteger.ONE);

            b = b.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }
        return a.divide(b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            BigInteger n = new BigInteger(st.nextToken());
            BigInteger m = new BigInteger(st.nextToken());
            bw.write(bridge(n,m) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
