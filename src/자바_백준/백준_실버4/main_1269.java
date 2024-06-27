package 자바_백준.백준_실버4;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
대칭 차집합
- 중요한건, 겹치는 원소를 구한다.
- 두가지 원소 수를 합한다음, 겹치는 원소를 뺀다.
 */
public class main_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setA2 = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<a; i++){
            int n = Integer.parseInt(st.nextToken());
            setA.add(n);
            setA2.add(n);
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<b; i++){
            setB.add(Integer.parseInt(st.nextToken()));
        }

        setA.removeAll(setB);
        setB.removeAll(setA2);

        bw.write(Integer.toString(setA.size() + setB.size()));
        bw.flush();
        br.close();
        bw.close();
    }
}
