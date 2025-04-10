package 자바_백준.백준_실버5;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[][] sort = new String[n][4];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ind = 0;
            while (st.hasMoreTokens()){
                sort[i][ind++] = st.nextToken(); //이름, 일, 월, 년도 순
            }
        }
        //sort 재정의
        Arrays.sort(sort, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) { //문자열 비교 좀 조심좀 해라!!!!!
                if(o1[3].equals(o2[3])){ //년도 같.
                    if(o1[2].equals(o2[2])){ //월 같
                        return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]); //마지막으로 일
                    }
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]); //다음은 월을 오름차순으로
                }
                return Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]); //기본은 년도
            }
        });

        bw.write(sort[sort.length-1][0] + "\n" + sort[0][0]);
        bw.flush();
        br.close();
        bw.close();
    }
}
