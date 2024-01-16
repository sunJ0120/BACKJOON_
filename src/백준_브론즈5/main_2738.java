package 백준_브론즈5;
import java.io.*;
import java.util.*;

public class main_2738 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //3 3
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //행렬 리스트 2개
        List<Integer> AList = new ArrayList<Integer>();
        List<Integer> BList = new ArrayList<Integer>();

        //행렬1
        for(int i = 0; i < N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " "); //1 1 1
            for(int j = 0; j < M; j++){ //1 1 1
                AList.add(Integer.parseInt(st2.nextToken()));
            }
        }

        //행렬2
        for(int i = 0; i < N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " "); //3 3 3
            for(int j = 0; j < M; j++){ //3 3 3
                BList.add(Integer.parseInt(st2.nextToken()));
            }
        }

        //더해서 내보내기
        for(int i = 0; i < N * M; i++){
            bw.write(AList.get(i)+ BList.get(i) + " ");

            if(i > 0 && i % N == 2){ //줄바꿈
                bw.write("\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
