package 자바_백준.개념.정렬;

import java.util.Arrays;

/*
합병 정렬
1. 반으로 계속 나눈다. 최소 단위가 나올 때까지 -> 재귀 호출
2. 비교해서 작은 것부터 합친다.
 */
public class MergeSortExample {
    //병합 정렬 함수
    public static void mergeSort(int[] arr){
        if(arr.length <= 1){
            return; //길이가 하나가 된다면, 재귀 종료
        }

        int mid = arr.length/2;

        int[] left = Arrays.copyOfRange(arr, 0, mid); //왼쪽 베열 카피
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        //재귀적으로 나누기
        mergeSort(left);
        mergeSort(right);

        //재귀가 끝나면 병합
        merge(arr, left, right);
    }

    public static void merge(int[] arr, int[] left, int right[]){
        int i = 0; //left 배열 인덱스
        int j = 0; //right 배열 인덱스
        int k = 0; //arr 배열 인덱스

        while(i < left.length && j < right.length){
            if(left[i] < right[j]){ //더 작은수를 비교해서 넣는다.
                arr[k++] = left[i++];
            }else{ //right가 더 작음
                arr[k++] = right[j++];
            }
        }

        while(i < left.length){ //더 남아있음, 한쪽 배열이 먼저 끝남.
            arr[k++] = left[i++]; //왜냐하면, 하나라도 먼저 끝나면 i < left.length && j < right.length 이게 끝나버리기 때문이다.
        }

        while(j < right.length){ //right가 남았을 경우
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,9,1,5,6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
