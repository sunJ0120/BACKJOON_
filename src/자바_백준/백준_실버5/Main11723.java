package 자바_백준.백준_실버5;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main11723 {

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String input = "";
            int n = 0;

            if(st.countTokens() == 2){
                input = st.nextToken();
                n = Integer.parseInt(st.nextToken());
            }else{
                input = st.nextToken();
            }

            if(input.equals("add")){
                add(n);
            }else if(input.equals("remove")){
                remove(n);
            }else if(input.equals("check")){
                bw.write(check(n) + "\n");
            }else if(input.equals("toggle")){
                toggle(n);
            }else if(input.equals("all")){
                all();
            }else{
                empty();
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static void add(int n) {
        set.add(n);
    }

    public static void remove(int n) {
        set.remove(n);
    }

    public static int check(int n) {
        if(set.contains(n)){
            return 1;
        }else{
            return 0;
        }
    }

    public static void toggle(int n){
        if(set.contains(n)){
            set.remove(n);
        }else{
            set.add(n);
        }
    }

    public static void all(){
        set.clear();
        for(int i = 1; i<=20; i++){
            set.add(i);
        }
    }

    public static void empty(){
        set.clear();
    }
}
