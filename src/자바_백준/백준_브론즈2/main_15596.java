package 자바_백준.백준_브론즈2;

import java.io.*;

/*
궁금점
여기서 num은 static으로 선언하지 않아도 괜찮나? - 예...이유는 적어둠
그리고 이런 문제는 test를 어케해 - 지금처럼 main을 직접 만들어서 반례를 넣어 살펴본다.
 */
class Test{
    public long sum(int[] a){
        long num = 0;
        for(long n : a){
            num += n;
        }
        return num;
    }
}

/*
Test
 */
public class main_15596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] li = new int[5];

        for(int i = 0; i<li.length; i++){
            li[i] = Integer.parseInt(br.readLine());
        }

        Test t = new Test();
        bw.write(t.sum(li) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
