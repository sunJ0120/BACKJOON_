package 자바_백준.백준_실버4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/*
입력으로 들어오는 포켓몬 이름, 번호를 각각 map으로 만들고
만약 입력으로 문자가 들어오면 번호를, 숫자가 들어오면 이름을 말하면 된다.

1. 숫자 string 판별법
2. value로 key찾기 다시 풀어야 함

결과 : 시간초과..

map을 두개를 선언해서 해주면 된다.....

변환하고 찾는 과정에서 시간이 너무 많이 소요되기 때문에, 두개를 선언하는게 낫다.
 */
public class main_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int poketmon = Integer.parseInt(st.nextToken());
        int ansloop = Integer.parseInt(st.nextToken());

        Map<Integer,String> pokedex = new HashMap<>();

        for (int i = 1; i <= poketmon; i++) {
            st = new StringTokenizer(br.readLine());
            pokedex.put(i, st.nextToken());
        }

        Set<Integer> keys = pokedex.keySet();
        for (int i = 0; i < ansloop; i++) {
            st = new StringTokenizer(br.readLine());
            //int인지 st인지 구별

            String stn = st.nextToken();

            if(Character.isDigit(stn.charAt(0))){ //숫자인지 판별하기 위함
                bw.write(pokedex.get(Integer.parseInt(stn)));
                bw.write("\n");
            }else{ //string, value가 주어짐. value로 찾기
                for(Integer key : keys){
                    if(pokedex.get(key).equals(stn)){ //string은 equal 쓰면 안 된다.
                        bw.write(key.toString());
                        bw.write("\n");
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
