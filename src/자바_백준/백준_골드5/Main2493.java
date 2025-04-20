package 자바_백준.백준_골드5;

import java.io.*;
import java.util.*;

/*
입력 형태
5
6 9 5 7 4
 */
public class Main2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tops = Integer.parseInt(br.readLine());
        Stack<Top> stackA = new Stack<>();
        Stack<Top> stackB = new Stack<>();
        List<Top> li = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<= tops; i++){
            Top top = new Top(i, Integer.parseInt(st.nextToken()));
            stackA.push(top);
        }

        while(!stackA.isEmpty()){
            if(stackB.isEmpty()){
                stackB.push(stackA.pop());
            }

            if(!stackA.isEmpty()){
                while(!stackB.isEmpty() && stackA.peek().height >= stackB.peek().height){
                    stackB.peek().arriveInd = stackA.peek().ind;
                    li.add(stackB.pop());
                }
                stackB.push(stackA.pop());
            }
        }

        while(!stackB.isEmpty()){ //stackB에 남은게 있을 경우
            li.add(stackB.pop());
        }

        li.sort(new Comparator<Top>() {
            @Override
            public int compare(Top o1, Top o2) { //자기 인덱스 별로 오름차순 정렬.
                return o1.ind - o2.ind;
            }
        });

        for(Top t : li){
            bw.write(t.arriveInd + " "); //도착한 인덱스만 적음/
        }

        bw.write("\n");
        bw.flush();
        bw.close();
        br.close();

    }
}

class Top{
    int height;
    int arriveInd = 0;
    int ind;

    public Top(int ind, int height){
        this.ind = ind;
        this.height = height;
    }
}
