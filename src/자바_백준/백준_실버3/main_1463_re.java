package 자바_백준.백준_실버3;

import java.io.*;

/*
복습

문제의 경우에, 최소를 구할때
그리고 2와 3으로 나눠지는 경우
그리고 -1을 할 경우
이거 경우의 수 어떻게 나누는지에 대해서 잘 알아야 한다.
 */
public class main_1463_re {
    public static Integer[] dpList;

    //움직이는 개 당 한번 +1이 니까 +1을 반드시 해야 한다!!!!!!!!!
    public static int dp(int num) {
        if(dpList[num] == null){ //없을 경우에만 저장.
            if(num % 6 == 0){ //6으로 나눠 떨어진다면,
                dpList[num] =  Math.min(dp(num / 3), Math.min(dp(num / 2), dp(num - 1))) + 1;
            }else if(num % 3 == 0){ //3으로 나눠 떨어진다면,
                dpList[num] = Math.min(dp(num / 3), dp(num - 1)) + 1;
            }else if(num % 2 == 0){ //2로 나눠 떨어진다면,
                dpList[num] = Math.min(dp(num / 2), dp(num - 1)) + 1;
            }else{
                dpList[num] = dp(num - 1) + 1;
            }
        }
        return dpList[num]; //종료 조건
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        dpList = new Integer[num+1];

        dpList[0] = 0; //초기화.
        dpList[1] = 0; //초기화.

        bw.write(dp(num) + "\n");
        bw.flush();
        br.close();
        bw.close();

    }
}
