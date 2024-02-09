package 백준_브론즈1;

import java.io.*;
import java.util.StringTokenizer;
/*
1월 1일 = 월요일
if 절을 통해 돌려서 월별로 누적 일수를 구한다.

일 월 화 수 목 금 토 일 순서인 리스트를 하나 생성한다.
7로 나눠서 나온 값을 인덱스로 이용해서 요일을 구한다.
 */
public class main_1924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int mon = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int sum = 0;

        String[] yoil = {"SUN","MON", "TUE", "WED", "THU", "FRI", "SAT"};

//        for(int i = 1; i< mon; i++){
//            if(i == 1||i == 3||i == 5||i == 7||i == 8||i == 10||i == 12){
//                sum += 31;
//            }else if(i == 2){
//                sum += 28;
//            }else{
//                sum += 30;
//            }
//        }

        /*
        배열로 푸는 방법
         */
        int[] daily = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        for(int i = 1; i< mon; i++){
            sum += daily[i];
        }

        sum += day;

        bw.write(yoil[sum % 7] + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
