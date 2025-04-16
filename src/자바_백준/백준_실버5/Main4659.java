package 자바_백준.백준_실버5;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/*
1. 모음만 두고 - 1 조건을 체크
2. 2 조건은 3개 연속인 경우 체크를 하는건데,
    - 자음, 모음을 판별해두고, TRUE FALSE가 연속으로 3개 이상 오는지를 본다.
3. 조건은 그냥 단순하게 포인터 두 개 두고 보면 된다.
    - 이것의 경우 길이가 1인 경우만 주의하기 (1인 경우는 skip하도록 하는것도 방법이다. 짜피 조건에 안걸리니까...)
 */
public class Main4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Character> moeum = Arrays.asList('a','e','i','o','u'); //초기화
        while(true){
            String str = br.readLine();
            if("end".equals(str)){
                break;
            }
            char[] chList = str.toCharArray(); //예) [p,t,o,u,i]

            if(isExistMoeum(chList, moeum) && isTripleChain(chList, moeum) && isDoubleCheck(chList)){
                bw.write("<"+ new String(chList) +"> is acceptable." +"\n");
            }else{ //하나라도 트루 아님.
                bw.write("<"+ new String(chList) +"> is not acceptable." +"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    //1 조건, 모음이 하나라도 있어야 한다.
    public static boolean isExistMoeum(char[] chList, List<Character> moeum){
        for(char ch : chList){
            if(moeum.contains(ch)){
                return true; //모음 안에 있을 경우 트루
            }
        }
        return false;
    }

    //2 조건, 3개가 연속으로 오면 안된다.
    public static boolean isTripleChain(char[] chList, List<Character> moeum){
        boolean[] checkTriple = new boolean[chList.length]; //모음은 트루, 자음은 false

        //리스트 채우기
        for(int i = 0; i<chList.length; i++){
            if(moeum.contains(chList[i])){ //모음일 경우
                checkTriple[i] = true;
            }else{ //자음일 경우
                checkTriple[i] = false;
            }
        }
        int trueCnt = 0;
        int falseCnt = 0;
        int ind = 0;
        while(ind < checkTriple.length) { //checkTriple의 끝까지만 검색
            if (checkTriple[ind]) { //모음일 경우
                trueCnt++;
                falseCnt = 0; //자음은 연속 끊겼으므로 초기화
            } else { //자음일 경우
                falseCnt++;
                trueCnt = 0; //모음은 연속 끊겼으므로 초기화
            }
            if (trueCnt >= 3 || falseCnt >= 3) { // 하나라도 세개 이상이면
                return false; //이 조건 체크를 안에서 해야 초기화 안되고 바로 빠져나옴.
            }
            ind++; //인데스 이동 까먹지 말기!!!
        }
        return true;
    }

    //3 조건, 같은 글자가 두 개 이상 오면 안된다. ee랑 oo만 가능
    public static boolean isDoubleCheck(char[] chList){
        if(chList.length <= 1){ //길이가 하나 이하
            return true;
        }

        int startInd = 0;
        int endInd = startInd +1;
        while(endInd < chList.length){
            if(chList[startInd] == chList[endInd]){ //두개가 같음
                if(!(chList[startInd] == 'e' && chList[endInd] == 'e') && !(chList[startInd] == 'o' && chList[endInd] == 'o')){ //e랑 o가 반복되는게 아닐 경우
                    return false;
                }
            }
            startInd++;
            endInd++;
        }
        return true; //조건에 안걸리면 트루
    }
}
