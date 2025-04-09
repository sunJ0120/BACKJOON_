package 자바_백준.백준_실버3;

import java.io.*;

/*
배열 미리 만들어서 반복문 쓰는 방식이 아닌
DP방식을 이용해서 해결해보자!
 */
public class main_1003_2 {
    static Integer[][] nList = new Integer[41][2]; //Integer(래퍼 클래스)를 이용해서 null을 검사

    public static Integer[] fibonacci(int num){ //이 부분에서 재귀, dp를 어떻게 활용할지가 좀 아이디어 얻기가 어려운듯..
        if(nList[num][0] == null && nList[num][1] == null){
            nList[num][0] = fibonacci(num-1)[0] + fibonacci(num-2)[0];
            nList[num][1] = fibonacci(num-1)[1] + fibonacci(num-2)[1];
        }
        return nList[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        nList[0][0] = 1; //0은 0이 1개
        nList[0][1] = 0;

        nList[1][0] = 0;
        nList[1][1] = 1;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            bw.write(fibonacci(num)[0] + " ");
            bw.write(fibonacci(num)[1] + "\n");

        }

        bw.flush();
        br.close();
        bw.close();

    }
}
