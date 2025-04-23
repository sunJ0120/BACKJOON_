package 자바_백준.백준_골드5;

import java.io.*;
import java.util.*;

/*
모노틱 수열 이용하기

- 시간초과 해결하기
-- O(n)이 걸리는 indexOf이 아니라, 객체를 따로 생성해서 저장하자.

- 메모리 줄여보기
1. 스택에 인덱스만 저장해서, 인덱스 별 순서를 보장한다.
2. 높이를 따로 인덱스로 둔다
3. 결과를 저장하는 배열을 하나 만들어 두고, 스택 결과에 따라 result에 저장한다.

— 이렇게 하면 굳이 객체를 만들지 않고도 모노틱 수열 이용이 가능하다!
 */
public class Main2493_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int roop = Integer.parseInt(br.readLine());
        int[] result = new int[roop];
        int[] height = new int[roop];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<roop; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> sta = new Stack<>(); //인덱스만 올리고 높이는 배열로 비교함

        for(int i = 0; i<roop; i++){ //height 비교
            while(!sta.isEmpty() && height[i] > height[sta.peek()]){ //왼쪽이 더 클때까지 가야함.
                int ind = sta.pop();
                if(sta.isEmpty()){
                    result[ind] = 0;
                }else{
                    result[ind] = sta.peek()+1; //0기반이므로...
                }
            }

            if(sta.isEmpty()){
                sta.push(i); //인덱스 올리기
                continue;
            }

            if(height[i] < height[sta.peek()]){ //왼쪽이 더 크다.
                sta.push(i);
            }
        }

        while(!sta.isEmpty()){
            int ind = sta.pop();
            if(sta.isEmpty()){
                result[ind] = 0;
            }else{
                result[ind] = sta.peek()+1; //0기반이므로...
            }
        }

        for(int n : result){
            bw.write(n + " "); //해당 키의 값을 가져오면 변한 값 가져옴
        }
        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
