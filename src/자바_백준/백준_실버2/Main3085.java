package 자바_백준.백준_실버2;

import java.io.*;

public class Main3085 {

    static char[][] li;
    static int[][] cpzy;

    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        li = new char[num][num];
        cpzy = new int[num][num];

        for(int i = 0; i<num; i++){
            li[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i<num; i++){
            for(int j = 0; j<num-1; j++){
                //가로 swap
                swap(i,j);
                checkMaxRow(num, 'C');
                clear(num);
                checkMaxRow(num, 'P');
                clear(num);
                checkMaxRow(num, 'Z');
                clear(num);
                checkMaxRow(num, 'Y');
                swap(i,j);
            }
        }

        for(int i = 0; i<num-1; i++){
            for(int j = 0; j<num; j++){
                //세로 swap
                swap(j,i);
                checkMaxCulumn(num, 'C');
                clear(num);
                checkMaxCulumn(num, 'P');
                clear(num);
                checkMaxCulumn(num, 'Z');
                clear(num);
                checkMaxCulumn(num, 'Y');
                swap(j,i);
            }
        }
        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void swap(int i, int j){
        char a = li[i][j];
        li[i][j] = li[i][j+1];
        li[i][j+1] = a;
    }

    public static void checkMaxRow(int num, char c){ //가로 줄 체크
        for(int i = 0; i<num; i++){
            for(int j = 0; j<num; j++){
               if(li[i][j] == c){
                   cpzy[i][j] = (j > 0 ? cpzy[i][j-1] : 0) + 1;
                   max = Math.max(cpzy[i][j], max);
               }
            }
        }
    }

    public static void checkMaxCulumn(int num, char c){ //세로 줄 체크
        for(int i = 0; i<num; i++){
            for(int j = 0; j<num; j++){
                if(li[j][i] == c){
                    cpzy[j][i] = (j > 0 ? cpzy[j-1][i] : 0) + 1;
                    max = Math.max(cpzy[j][i], max);
                }
            }
        }
    }

    public static void clear(int num){
        for(int i = 0; i<num; i++){
            for(int j = 0; j<num; j++){
                cpzy[i][j] = 0;
            }
        }
    }
}
