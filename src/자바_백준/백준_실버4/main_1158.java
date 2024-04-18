package 자바_백준.백준_실버4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
요세푸스 문제
중요한 것은, n을 나눈 나머지를 구해서 그걸 하나하나 지워가는 것이다.
이거 헷갈리는데, 안에서 계속 돌아야 하나..? 풀이를 찾아보자.
 */
public class main_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = n;
        int num = 1;
        int ans;

        List<Integer> nlist = new ArrayList<Integer>(n);
        List<Integer> anslist = new ArrayList<Integer>();

        for(int i = 1; i<=n; i++){
            nlist.add(i);
        }

        while(anslist.size() <= n){
            ans = num * k;
            if(ans%count != 0){
                anslist.add(ans%n);
                count--;
            }else{ //0이다!
                anslist.add(n);
            }
        }

//        bw.write("< ");
//        while(count <= n){
//            ans = num * k;
//            if(ans%n != 0){
//                if(count == n){
//                    bw.write(ans%n);
//                }else{
//                    bw.write(ans%n + ", ");
//                }
//            }else{ //0이다!
//                if(count == n){
//                    bw.write(n);
//                }else{
//                    bw.write(n + ", ");
//                }
//            }
//            count++; //하나 적었으니 count 증가
//            num++;
//        }
//        bw.write(">");

        bw.flush();
        br.close();
        bw.close();
    }
}
