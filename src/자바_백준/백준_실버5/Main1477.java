package 자바_백준.백준_실버5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
- 단순하게 보면 max이면 되는거지만..
- 최소로 매수해서 국회의원이 되기 위해서는 최대인 사람의 사람 수를 하나씩 빼야 한다.
- 최대인 사람의 사람수를 1번 사람에게 더하고, max값이 1번 사람이 된다면 멈추고 return한다.
 */

/*
- max를 어떻게 갱신해야 while을 바로 끝낼 수 있지..?깔끔하게
 */
public class Main1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int roop = Integer.parseInt(br.readLine());

        int[] supporter = new int[roop];
        for(int i = 0; i<roop; i++){
            supporter[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 0;

        while(true){
            //max구하기
            int max = Integer.MIN_VALUE; //max값은 루프때마다 계속 다시 계산해야 한다.
            int maxInd = 0;

            for(int i = 0; i<roop; i++){
                max = Math.max(max,supporter[i]);
                if(max == supporter[i]){ //바뀜
                    maxInd = i;
                }
            }
            if(maxInd == 0){ //이미 max이면 더 이상 사람수를 더할 필요는 없다.
                break;
                //값으로 비교할 수 없는 이유는, 동급 ( 10 10 10 10 )일 경우가 체크되기 때문에 인덱스로 비교해서 유일무이하게 일등일때만 비교가 가능하도록 한다.
            }
            supporter[0]++;
            supporter[maxInd]--;
            cnt++;
        }
        System.out.println(cnt);
    }
}
