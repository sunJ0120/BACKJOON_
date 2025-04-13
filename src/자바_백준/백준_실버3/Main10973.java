package 자바_백준.백준_실버3;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
- 뒤의 숫자가 내림차순일때까지 swap한다.
    - 뒤의 숫자가 내림차순이라면 swap하고 멈춘다음 결과를 내보낸다.
- 이때, 완전 오름차순(맨 앞 숫자) 일 경우, -1을 출력한다.
 */

/*
수정 : 내림차순인 부분을 찾아서, 뒤에서 가장 큰데 수보다 작은 수를 찾아서 SWAP한다.
- 다음부터 내림차순 정렬한다.
 */

public class Main10973 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] li = new Integer[length];

        for(int i = 0; i<length; i++){
            li[i] = Integer.parseInt(st.nextToken());
        }

        //완전 오름차순인지 검증
        if(isAsc(li)){
            bw.write(-1+ "");
        }else{ //완전 오름차순 아님
            int exInd = 0;
            int max = 0; //exInd보다 작지만 큰 수
            int maxInd = 0;

            for(int i = li.length-1; i>0; i--){
                if(li[i-1] > li[i]){ //내림차순 찾기
                    exInd = i-1;
                    break;
                }
            }

            for(int i = exInd+1; i<= li.length-1; i++){ //끝까지 swap해야 한다.
                if(li[i] < li[exInd] && max < li[i]){
                    max = li[i];
                    maxInd = i; //swap용 인덱스 저장
                }
            }

            swap(li, exInd, maxInd); //내림차순 부분이랑 swap
            //나머지 내림차순
            Arrays.sort(li, exInd+1, li.length, new Comparator<Integer>(
            ) {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1; //내림차순
                }
            });

            for(int n : li){
                bw.write(n+ " ");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void swap(Integer[] li, int a, int b){
        int c = li[a];
        li[a] = li[b];
        li[b] = c;
    }

    public static boolean isAsc(Integer[] li){
        for(int i = 0; i<li.length-1; i++){
            if(li[i] > li[i+1]){ //이전것이 더 크다.
                return false;
            }
        }
        return true;
    }
}
