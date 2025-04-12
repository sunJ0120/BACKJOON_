package 자바_백준.백준_실버3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
합병 정렬
1. 왼쪽 오른쪽으로 나눈다.
2. 왼오가 교차하지 않을 때까지 쪼갠다.
3. 합병해서, 새로운 배열에 둘을 비교해서 작은 순으로 넣는다.
    - 여기서, 왼쪽 이나 오른쪽이 더 남았을 경우에는 남은걸 전부 넣는다.
 */
public class Main24060 {
    static int cnt;
    static int K;

    static int ansNum;

    public static void mergeSort(int[] li, int le, int ri){ //배열, 시작, 끝
        if(le < ri){ //커지거나 같아지면 return으로 종료
            int mid = (le+ri)/2; //중간 인덱스 주의!! (gpt 도움 받음)
            mergeSort(li, le, mid);
            mergeSort(li, mid+1, ri);
            merge(li,le,mid,ri); //합병 : 배열, 시작, 중간, 끝 (한번에 비교하기 위해, 중간까지 넣어야 한다.)
        }
    }

    public static void merge(int[] li, int start, int mid, int end){
        int[] tmp = new int[end-start+1]; //복사용 배열
        int k = 0; //ans배열에 넣는순
        int leftStart = start; //왼쪽 시작
        int leftEnd = mid; //왼쪽 끝
        int rightStart = mid+1;
        int rightEnd = end;

        while (leftStart <= leftEnd && rightStart <= rightEnd) { //왼쪽이 끝까지 가거나, 오른쪽이 끝까지 가거나.
            if(li[leftStart] < li[rightStart]){
                tmp[k++] = li[leftStart++];
            }else{
                tmp[k++] = li[rightStart++];
            }
        }

        //left가 남아있을 경우
        while(leftStart <= leftEnd){
            tmp[k++] = li[leftStart++];
        }
        //right가 남아 있을 경우
        while(rightStart <= rightEnd) {
            tmp[k++] = li[rightStart++];
        }
        //tmp 배열에 복사
        for(int i = 0; i<tmp.length; i++){
            cnt++;
            li[i + start] = tmp[i];
            if(cnt == K){
                ansNum = tmp[i];
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //배열의 크기
        K = Integer.parseInt(st.nextToken()); //저장 횟수

        st = new StringTokenizer(br.readLine());
        int[] li = new int[n];
        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(st.nextToken());
            li[i] = num;
        }

        cnt = 0;
        ansNum = 0;
        mergeSort(li, 0, n-1);
//        System.out.println(Arrays.toString(li));
        System.out.println(ansNum == 0 ? -1 : ansNum); //mergeSort
    }
}
