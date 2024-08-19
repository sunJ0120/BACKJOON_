package 자바_백준.백준_실버3;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class main_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int cnt = 0; //정답에 사용할 count

        LinkedList<Integer> deque = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int numIndex = deque.indexOf(num);

            int middleIndex = 0;
            if(deque.size() % 2 == 0){ //짝수
                middleIndex = (deque.size() / 2) - 1;
            }else{ //홀수
                middleIndex = (deque.size() / 2);
            }
            if(middleIndex < numIndex){ //middle에 있는 것 보다 크다.
                while(deque.peek() != num){ //맨 앞으로 올 때까지
                    deque.addFirst(deque.getLast());
                    deque.removeLast();
                    cnt++;
                }
                deque.pop(); //수 빼기
            }else{ //middle에 있는 것 보다 작다.
                if(numIndex != 0) {
                    while (deque.peek() != num) { //맨 앞으로 올 때까지
                        deque.addLast(deque.pop());
                        cnt++;
                    }
                }
                deque.pop(); //수 빼기
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
