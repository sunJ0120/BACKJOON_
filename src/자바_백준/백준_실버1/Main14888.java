package 자바_백준.백준_실버1;

import java.io.*;
import java.util.StringTokenizer;

public class Main14888 {
    static int[] operator;
    static int[] numbers;
    static int min;
    static int max;

    public static void greedy(int ind, int ans){
        if(ind >= numbers.length){
            min = Math.min(ans,min);
            max = Math.max(ans,max);
            return;
        }

        //연산자 4방향 모두 순회한다. 시작값을 고정하면 된다.
        for(int i = 0; i<4; i++){
            if(operator[i] == 0){ //0개일 경우엔 넘어간다.
                continue;
            }

            int next = numbers[ind]; //계산을 위한 다음 숫자
            operator[i]--;
            if(i == 0){ //+
                greedy(ind+1, ans+next); //숫자 인덱스도 하나 전진.
            }else if(i == 1){ //-
                greedy(ind+1, ans-next);
            }else if(i == 2){
                greedy(ind+1, ans*next);
            }else{
                greedy(ind+1, ans/next);
            }
            operator[i]++; //operator 다시 되돌리기
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numbers = new int[num];
        operator = new int[4]; //0 : +, 1 : -, 2 : x, 3 : /
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for(int i = 0; i<num; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        //연산자 넣기
        for(int i = 0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        int ans = numbers[0]; //0번째 이후부터 연산자가 들어감.

        // 숫자 인덱스, min, max 값을 정할 ans와
        greedy(1, ans);

        bw.write(max + "\n" + min);
        bw.flush();
        bw.close();
        br.close();
    }
}
