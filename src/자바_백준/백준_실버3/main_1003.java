package 자바_백준.백준_실버3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
DP문제

근데 이게 DP로 하면 어떤 문제가 있냐면,,
스루해

나는 배열을 미리 만들어 두는 방법밖에 모르겠음..
이걸 dp로 풀려면 배열 두개가 필요한데 어케 푸는지..?
 */
public class main_1003 {

    static List<Integer> zero = new ArrayList();
    static List<Integer> one = new ArrayList();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        //초기화
        zero.add(0,1);
        zero.add(1,0);

        one.add(0,0);
        one.add(1,1);

        //미리 만들어두기.
        for (int i = 2; i < 41; i++) {
            zero.add(i, zero.get(i-1) + zero.get(i-2));
            one.add(i, one.get(i-1) + one.get(i-2));
        }

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            bw.write(zero.get(num) + " ");
            bw.write(one.get(num) + "\n");

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
