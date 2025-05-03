package 자바_백준.백준_실버3;

import java.io.*;
import java.util.*;

public class Main1966_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int roop = Integer.parseInt(br.readLine());

        for(int i = 0; i<roop; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int leng = Integer.parseInt(st.nextToken());
            int findInd = Integer.parseInt(st.nextToken());

            Integer[] li = new Integer[leng];
            Queue<Integer> priorQue = new ArrayDeque<>();
            Queue<Integer> indQue = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<leng; j++){
                int n = Integer.parseInt(st.nextToken());
                li[j] = n;
                priorQue.add(n);
                indQue.add(j);
            }
            //내림차순
            Arrays.sort(li, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });

            for(int j = 0; j<li.length; j++){
                while(true){
                    if(priorQue.peek().equals(li[j])){ //우선순위 차례.
                        break;
                    }
                    priorQue.add(priorQue.poll());
                    indQue.add(indQue.poll());
                }
                priorQue.poll();
                int ind = indQue.poll();

                if(findInd == ind){
                    bw.write(j+1 + "\n");
                    break; //찾으면 더 이상 할 필요 없음.
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
