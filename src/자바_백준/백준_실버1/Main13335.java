package 자바_백준.백준_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* n :  트럭수 , w : 다리 길이, L : 최대 하중
*
1. Queue 두 개 만들어서 다리, 대기 구현
2. 다리와 대기의 peek 계산해서
    1. 다리의 모든 원소를 돌면서 더한 값이랑 더했을 때 L보다 작으면 올리고
        1. 다리의 원소들은 뺀 다음 다시 계속 넣어야 한다.
    2. 크면 0을 올린다.
3. 다리에 있는 모든 것들의 크기가 w가 되면
    1. 맨 앞에꺼 + 0이 있다면 0 넣었던 것들을 뺀다. (다리에서 빠져나가는 과정)
4. 다리 빌 때까지 돌면서 roop를 돈다.
    1. 무조건 하나 올려야 하므로 do while로 구성해보기
 */
public class Main13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int ans = 0;

        st = new StringTokenizer(br.readLine());
        Queue<Integer> wait = new ArrayDeque<>();
        Queue<Integer> bridge = new ArrayDeque<>();
        for(int i = 0; i<n; i++){
            wait.add(Integer.parseInt(st.nextToken()));
        }

        while(true){
            ans++; //루프 더하기
            //w 체크하기, 다음 루프에서 나간다.
            if(bridge.size() >= w){
                bridge.poll(); //하나 내보내기
                while(!bridge.isEmpty() && bridge.peek() == 0){ //0이 있으면 내보내야 하므로, 비어 있으면 peek 할 수 없으므로 체크
                    bridge.poll();
                }
            }

            if(bridge.isEmpty() && wait.isEmpty()){ //둘다 없으면 끝내기
                 break;
            }

            int addTruck = wait.isEmpty() ? 0 : wait.peek(); //비어 있으면 0 올리기
            int sumWeight = 0;

            //다리 내 트럭들 전체 더하기
            for(int i = 0; i<bridge.size(); i++){
                int truck = bridge.poll();
                sumWeight += truck;
                bridge.add(truck); //더하고 다시 올리기
            }

            //다리에 더하기
            if(addTruck != 0 && addTruck + sumWeight <= L){ //L보다 작거나 같아야 한다, 그런데 여기서 addTruck이 0이 아니어야함
                bridge.add(wait.poll());
            }else{
                bridge.add(0);
            }
        }
        System.out.println(ans);
    }
}
