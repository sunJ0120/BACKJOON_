package 자바_백준.백준_실버4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
hashMap을 두개를 만든다.
 */

public class main_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int poketmon = Integer.parseInt(st.nextToken());
        int ansloop = Integer.parseInt(st.nextToken());

        Map<Integer,String> pokedex = new HashMap<>();
        Map<String,Integer> pokedexReverse = new HashMap<>();

        for (int i = 1; i <= poketmon; i++) {
            String str = br.readLine();
            pokedex.put(i, str);
            pokedexReverse.put(str, i);
        }

        for (int i = 0; i < ansloop; i++) {
            String str = br.readLine();
            //int인지 st인지 구별

            if(49 <= str.charAt(0) && str.charAt(0) <= 57){ //int
                bw.write(pokedex.get(Integer.parseInt(str)));
                bw.write("\n");
            }else{ //string
                bw.write(pokedexReverse.get(str).toString());
                bw.write("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
