package 자바_백준.백준_브론즈1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
- Comparator 재정의
- 내림차순 정렬 (비교할때 Long으로 바뿨서 비교하기)
- 가장 앞에 오는 객체의 이름을 return
 */
public class Main11557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int roop = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i<roop; i++){
            int cnt = Integer.parseInt(br.readLine());
            String[][] grade = new String[cnt][2];
            for(int j = 0; j<cnt; j++){
                st = new StringTokenizer(br.readLine());
                grade[j][0] = st.nextToken(); //이름
                grade[j][1] = st.nextToken(); //먹는양
            }

            Arrays.sort(grade, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    if(Long.parseLong(o2[1]) > Long.parseLong(o1[1])){ //더 크다.
                        return 1; //swap //바꿔서 내림차순으로
                    }
                    return -1; //이외에는 non-swap
                }
            });
            bw.write(grade[0][0] + "\n"); //이름 담기
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
