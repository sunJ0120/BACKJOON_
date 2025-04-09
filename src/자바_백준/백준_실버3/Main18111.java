package 자바_백준.백준_실버3;

import java.io.*;
import java.util.StringTokenizer;

public class Main18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int inven = Integer.parseInt(st.nextToken());

        int ans = Integer.MAX_VALUE;
        int height = 0;

        int max = 0;
        int min = Integer.MAX_VALUE;

        int[] map = new int[n*m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                max = num > max ? num : max;
                min = num < min ? num : min;

                map[(i*m)+j] = num;
            }
        }

        for(int i = max; i>=min; i--){
            boolean flag = true;
            int inv = inven;
            int time = 0;

            for(int j = 0; j<map.length; j++){
                if (map[j] < i) {
                    int diff = i - map[j];
                    inv -= diff;
                    time += diff;
                } else if (map[j] > i) {
                    int diff = map[j] - i;
                    inv += diff;
                    time += diff * 2;
                }
            }

            if(inv < 0){ //더 이상 뺄 수 없는데 빼려고 시도한 것
                flag = false;
            }

            if(flag){ //true일 경우에만
                //같은 경우는 어차피 height가 계속 줄어드는거라 안해도 괜찮지 않나 싶음..
                if(ans > time){ //새로 적은 time이 더 작다.
                    ans = time;
                    height = i;
                }
            }
        }
        bw.write(ans + " " + height + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
