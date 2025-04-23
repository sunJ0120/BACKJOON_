package 자바_백준.백준_골드5;

import java.io.*;
import java.util.*;

/*
모노틱 수열 이용하기

- 시간초과 해결하기
-- O(n)이 걸리는 indexOf이 아니라, 객체를 따로 생성해서 저장하자.
 */
public class Main2493_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int roop = Integer.parseInt(br.readLine());

        List<Tower> li = new ArrayList<>(); //넣을 순서를 위해 필요함. indexOf을 사용하기 위해 바꿈

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<roop; i++){
            Tower top = new Tower(i,Integer.parseInt(st.nextToken())); //인덱스랑 높이
            li.add(top);
        }

        Stack<Tower> sta = new Stack<>();

        int ind = 0;
        while(ind < roop){
            if(sta.isEmpty()){
                sta.push(li.get(ind++));
            }else{
                if(li.get(ind).height > sta.peek().height){ //여기는 인덱스 안움직임
                    while(!sta.isEmpty() && li.get(ind).height > sta.peek().height){
                        int n = sta.pop().index;
                        if(sta.isEmpty()){
                            break; //원래 기본 -1 넣어놨으므로
                        }else{
                            li.get(n).leftHeight = sta.peek().index;
                        }
                    }
                }else{ //li[ind] < sta.peek() 왼쪽이 더 크다.
                     sta.push(li.get(ind++));
                }
            }
        }

        while(!sta.isEmpty()){
            int n = sta.pop().index;
            if(sta.isEmpty()){
                break; //원래 기본 -1 넣어놨으므로
            }else{
                li.get(n).leftHeight = sta.peek().index;
            }
        }

        li.sort(new Comparator<Tower>() {
            @Override
            public int compare(Tower o1, Tower o2) {
                return o1.index - o2.index;
            }
        });


        for(Tower n : li){
            bw.write(n.leftHeight+1 + " "); //해당 키의 값을 가져오면 변한 값 가져옴
        }
        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

class Tower{
    int index;
    int height;
    int leftHeight;

    public Tower(int index, int height){
        this.height = height;
        this.index = index;
        leftHeight = -1;
    }
}
