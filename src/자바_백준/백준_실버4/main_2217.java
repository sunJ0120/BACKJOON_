package 자바_백준.백준_실버4;
import java.io.*;

public class main_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int minRoop = Integer.parseInt(br.readLine());

        for (int i = 1; i < num; i++) {
            int roop = Integer.parseInt(br.readLine());
            if(roop < minRoop){
                minRoop = roop;
            }
        }

        int ans = num * minRoop;

        bw.write(ans + "\n");
        bw.flush();
        br.close();
        bw.close();

    }
}
