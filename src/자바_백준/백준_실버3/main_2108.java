package 자바_백준.백준_실버3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

/*
음수일 수 있으므로, 수를 계산하기 위해서는 양수화 시켜야 한다.
 */
public class main_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int avg = 0;
        int mid = 0;
        int mod = 0;
        int ran = 0;

        List<Integer> num = new ArrayList<>(n); //수 저장용
        int[] nList = new int[(4000*2)+1]; //0 -> 4000
        int max = 0;

        for (int i = 0; i < n; i++) {
            num.add(Integer.parseInt(br.readLine()));
            nList[num.get(i) + 4000]++;

            if(nList[num.get(i) + 4000] > max){
                max = nList[num.get(i) + 4000];
            }
            avg += num.get(i);
        }

        sort(num);

        avg = Math.round((float) avg / n);
        mid = num.get(n/2);
        ran = num.get(n-1) - num.get(0);

        //최빈값
        boolean flag = false;
        for (int i = 0; i < nList.length; i++) {
            if(nList[i] == max){
                if(flag == true){ //이미 true, 즉 두번째로 작은 값.
                    mod = i - 4000;
                    break;
                }
                mod = i - 4000; //우선 저장
                flag = true;
            }
        }

        bw.write(avg + "\n");
        bw.write(mid + "\n");
        bw.write(mod + "\n");
        bw.write(ran + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
