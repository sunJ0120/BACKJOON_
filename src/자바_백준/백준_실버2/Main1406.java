package 자바_백준.백준_실버2;

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        int roop = Integer.parseInt(br.readLine());

        Stack<Character> left_cursor = new Stack<>();
        Stack<Character> right_cursor = new Stack<>();

        for(char c : ch){
            left_cursor.add(c);
        }

        for(int i = 0; i<roop; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] command = new char[2];
            int ind = 0;
            while(st.hasMoreTokens()){
                command[ind++] = st.nextToken().toCharArray()[0];
            }

            if(command[0] == 'L' && !left_cursor.isEmpty()){
                right_cursor.push(left_cursor.pop());
            }

            if(command[0] == 'D' && !right_cursor.isEmpty()){
                left_cursor.push(right_cursor.pop());
            }

            if(command[0] == 'B' && !left_cursor.isEmpty()){
                left_cursor.pop();
            }

            if(command[0] == 'P'){
                left_cursor.push(command[1]);
            }
        }

        StringBuilder stb = new StringBuilder();
        while (!right_cursor.isEmpty()){
            left_cursor.push(right_cursor.pop());
        }
        while(!left_cursor.isEmpty()){
            stb.append(left_cursor.pop());
        }
        System.out.println(stb.reverse());
    }
}

