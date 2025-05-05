package 자바_백준.백준_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1021 {
    static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //큐의 크기
        int k = Integer.parseInt(st.nextToken()); //뽑아내려고 하는 수
        int ans = 0;

        List<Integer> cycleQue = new ArrayList<>();
        List<Integer> pickNumList = new ArrayList<>();

        for(int i = 1; i<= n; i++){
            cycleQue.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<k; i++) {
            int pickNum = Integer.parseInt(st.nextToken()); //뽑은 수, 가장 처음 큐에서의 위치 이므로,,,, 수를 미리 뽑아야 한다.
            pickNumList.add(cycleQue.get(pickNum-1));

        }
        for(int i = 0; i<k; i++){
            int ind = index > cycleQue.size()-1 ? cycleQue.size()-1 : index; //맘에 안든다....
            int left = cycle(cycleQue, ind, pickNumList.get(i), cycleQue.size(), true);
            int right = cycle(cycleQue, ind, pickNumList.get(i), cycleQue.size(), false);
            ans += Math.min(left, right);
            ind = index; //받아온 걸로 바꾸기.
            cycleQue.remove(ind); //해당하는 수 지우기
        }
        System.out.println(ans);
    }

    public static int cycle(List<Integer> cycleQue, int ind, int pickNum, int size, boolean isLeft){
        if(cycleQue.get(ind) == pickNum){
            index = ind;
            return 0; //이동 안해도 된다.
        }

        return isLeft == true ? cycle(cycleQue, (((ind+1)+size)%size), pickNum,size,true)+1 : cycle(cycleQue, (((ind-1)+size)%size), pickNum,size,false)+1;
    }
}
