package 자바_백준.백준_골드5;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int roop = Integer.parseInt(br.readLine());

        for(int i = 0; i<roop; i++){
            //전처리
            StringBuilder stb = new StringBuilder();

            char[] comm = br.readLine().toCharArray();
            int num = Integer.parseInt(br.readLine());
            String str = br.readLine().replace("[","").replace("]","");
            StringTokenizer st = new StringTokenizer(str, ", ");
            Deque<Integer> que = new ArrayDeque<>();
            boolean pointer = true; //앞 뒤 체크용 플래그, 처음에는 정방향

            while(st.hasMoreTokens()){
                que.add(Integer.parseInt(st.nextToken()));
            }

            boolean emptyFlag = false; //기본은 비지 않았으므로.

            //시작
            for(char c : comm){
                if(emptyFlag){ //비어 있음.
                    break;
                }else{
                    if(c == 'R'){
                        pointer = reverse(pointer);
                    }else{ //'D'
                        emptyFlag = delete(pointer,que, stb); //empty checking은 delete만.
                    }
                }
            }
            //print
            if(emptyFlag){ //true, empty
                bw.write("error" + "\n");
            }else{
                bw.write(print(pointer,que, stb) +"\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }


    public static boolean reverse(boolean pointer){
        return (pointer == true) ? false : true; //pointer 뒤집기
    }

    public static boolean delete(boolean pointer,Deque<Integer> que, StringBuilder stb) throws IOException{
        if(que.isEmpty()){
            return true;
        }

        if(!pointer){ //false
            que.pollLast(); //반대로 뽑기
        }else{
            que.pollFirst(); //정방향 뽑기
        }

        return false;
    }

    public static String print(boolean pointer,Deque<Integer> que, StringBuilder stb) throws IOException{
        stb.append("[");
        if(!que.isEmpty()){ //empty check 추가....
            if(!pointer){ //역방향
                while(!que.isEmpty()){
                    stb.append(que.pollLast() + ",");
                }
                stb.delete(stb.length()-1, stb.length()); //끝부분 , 없애기
            }else{
                while(!que.isEmpty()){
                    stb.append(que.pollFirst() + ",");
                }
                stb.delete(stb.length()-1, stb.length()); //끝부분 , 없애기
            }
        }
        stb.append("]");

        return stb.toString();
    }
}
