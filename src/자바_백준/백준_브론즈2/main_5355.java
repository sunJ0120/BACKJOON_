package 자바_백준.백준_브론즈2;

import java.io.*;

public class main_5355 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            String[] st = br.readLine().split(" ");

            double d = Double.parseDouble(st[0]);

            for(int j = 1; j<st.length;j++){
                if(st[j].equals("@")){
                    d *= 3;
                }else if(st[j].equals("%")){
                    d += 5;
                }else{
                    d -= 7;
                }
            }

            String fo = String.format("%.2f", d); //format 하는법 알아두기
            bw.write(fo + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
