package 자바_백준.백준_실버5;

/*
비교조건이 두가지나 되므로, Arrays.sort의 Comparator를 재정의 하는 방법으로 해결한다.
- 사전순의 경우 conpareTo를 이용해 비교한다.
- 사전순이 아닌 경우, length를 빼준다.
- Arrays.sort의 compare의 경우, -1,0,1을 이용해 값을 비교한다.
재정의 하는 방법은 블로그를 참조
 */
import java.io.*;
import java.util.*;

public class main_1181 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String[] str = new String[num];

        for (int i = 0; i < num; i++) {
            str[i] = br.readLine();
        }

<<<<<<< HEAD
//        Arrays.sort(str, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                if (o1.length() == o2.length()) {
//                    return o1.compareTo(o2); //사전순
//                } else {
//                    return o1.length() - o2.length(); //길이순
//                }
//            }
//        });

        //람다식
        Arrays.sort(str, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2); //사전순
            } else {
                return o1.length() - o2.length(); //길이순
            }
        });

        bw.write(str[0] + "\n");
        //중복제거
        for(int i = 1; i < num; i++){
            if(!(str[i-1].equals(str[i]))){
                bw.write(str[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
=======
        Arrays.sort(str,)
        });
>>>>>>> try
    }
}
