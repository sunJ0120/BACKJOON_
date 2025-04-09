package 자바_백준.백준_실버5;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int human = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());

        int[][] player = new int[human][3];
        int[] numberMedal = new int[3];

        for(int i = 0; i<human; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j<3; j++){
                player[i][j] = Integer.parseInt(st.nextToken());
            }
            if(num == number){ //찾고 있는 선수의 번호
                numberMedal = player[i];
            }
        }
        Arrays.sort(player, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) { // o1 > o2이면 o1이 뒤로가는 오름차순
                if(o1[0] != o2[0]){
                    return o2[0] - o1[0]; //같지 않으면 내림차순 정렬
                }else if(o1[1] != o2[1]) { // if가 안으로 들어갈 필요 없이, 같으면 다음 조건 이동
                    return o2[1] - o1[1]; //은메달 내림차순
                }else{
                    return o2[2] - o1[2]; //동메달 내림차순
                }
            }
        });

        int rank = 1;
        for(int i = 0; i<human; i++){
            if(Arrays.equals(numberMedal,player[i])){
                System.out.println(rank);
                break;
            }
            rank++;
        }
    }
}
