package 자바_백준.백준_실버4;

import java.io.*;
import java.util.StringTokenizer;

public class Main1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] li = new int[num];

        int ind = 0;

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            li[ind++] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int stand = Integer.parseInt(st.nextToken())-1;

            if(gender == 1){ //남자
                for(int j = stand; j<li.length; j+=(stand+1)){
                    if(li[j] == 0){ //반대로
                        li[j] = 1;
                    }else{
                        li[j] = 0;
                    }
                }
            }else{ //여자
                int start = stand;
                int end = stand;

                while (start >= 0 && end < li.length) {
                    if(li[start] == li[end]){
                        if(li[start] == 0){ //반대로
                            li[start] = 1;
                            li[end] = 1;
                        }else{
                            li[start] = 0;
                            li[end] = 0;
                        }
                        start--;
                        end++;
                    }else{ //같지않으면 범위 끝
                        break;
                    }
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i<li.length; i++){
            bw.write(li[i] + " ");
            cnt++;
            if(cnt == 20){
                bw.write("\n");
                cnt = 0;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
