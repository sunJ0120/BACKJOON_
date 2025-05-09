package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main17478 {
    static StringBuilder stb;
    static String end;
    static int n;

    public static void printUnderScore(int cnt){
        for(int i = 0; i<cnt;i++){
            stb.append("____");
        }
    }

    public static void recur(int cnt){
        printUnderScore(cnt);
        stb.append("\"재귀함수가 뭔가요?\"\n");

        if(cnt == n){
            printUnderScore(cnt);
            stb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");

            printUnderScore(cnt);
            stb.append("라고 답변하였지.\n");
            return; //end
        }

        printUnderScore(cnt);
        stb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");

        printUnderScore(cnt);
        stb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");

        printUnderScore(cnt);
        stb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");

        recur(cnt+1); //재귀

        printUnderScore(cnt);
        stb.append("라고 답변하였지.\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stb = new StringBuilder();
        end = "라고 답변하였지.\n";

        stb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

        n = Integer.parseInt(br.readLine());

        recur(0);
        System.out.println(stb);

    }
}
