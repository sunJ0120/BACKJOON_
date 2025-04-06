package 자바_백준.백준_실버2.복습;

import java.io.*;
public class Main3085 {
    static char[][] ch;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        ch = new char[num][num];
        max = 1;

        for (int i = 0; i < num; i++) {
            ch[i] = br.readLine().toCharArray();
        }

        //swap 가로
        for(int i = 0; i<num; i++){
            for(int j = 0; j<num-1; j++){
                swap(i, j,0);
                check(num);
                swap(i, j,0); //되돌리기

                swap(i, j,1);
                check(num);
                swap(i, j,1); //되돌리기
            }
        }
        System.out.println(max);
    }

    //인덱스 체크 해야함.
    public static void swap(int a, int b,int n){ //index, 행렬, 방향 (0이면 가로, 1이면 세로)
        if(n == 0){ //가로
            char c = ch[a][b];
            ch[a][b] = ch[a][b+1];
            ch[a][b+1] = c;
        }else{ //세로
            char c = ch[b][a];
            ch[b][a] = ch[b+1][a];
            ch[b+1][a] = c;
        }
    }

    //검사
    public static void check(int num){ //행렬만 받기, 가로 세로 판별
        for(int i = 0; i<num;i++){
            int a = 1; //초기화 위치 주의
            for(int j = 0; j<num-1;j++){
                if (ch[i][j] == ch[i][j + 1]) { //가로
                    a++;
                    max = Math.max(a, max);
                } else {
                    a = 1; //1로 초기화
                }
            }

            a = 1; //한번 초기화를 해야한다!
            for(int j = 0; j<num-1;j++){
                if (ch[j][i] == ch[j + 1][i]) { //세로
                    a++;
                    max = Math.max(a, max);
                } else {
                    a = 1; //1로 초기화
                }
            }
        }
    }
}

