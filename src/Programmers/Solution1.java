package Programmers;

import java.util.ArrayList;
import java.util.List;

/*
구현해야 할 것들은 다음과 같다.
1. 유클리드 호제법을 이용해서 최대공약수를 구하는 method
2. 각 배열을 돌면서 최대 공약수를 n-1번만!!! 나누기
3. 전부 곱하기~

* 생각치 못한 복병! : 숫자 자릿수가 넘어갈 수 잇다.
- 1안 : 일단 long으로 처리해본다.
- 2안 : 그 다음 BigInt로 처리한다.

* 완전히 로직을 잘못 이해하고 있었다!
- chain 방식으로 누적하는 방식을 사용한다.
1. 계산은 앞에서 부터 두 개씩 계산하는 식으로 간다.
    - 어짜피 밀리니까 상관없을듯~
2. 하나만 남을때까지 계속하면~ 그게 최소 공배수가 된다.

* 그러니까 구현하는 방식은
1. while문으로 돌려서 하나 남을 때까지 지속한다.
2. 두 수를 최소 공배수를 구하는 로직에 넣고, 계산 값을 더하고, 두수를 빼고를 반복.
- 최소 공배수는 앞에서 했던 것과 마찬가지로 유클리드 호제법을 이용한다.
- 유클리드 호제법은, 나머지가 0일 때까지 나누는 수와 나머지를 계~속 나누는 식이고, 결국 나머지가 0일때 몫이 답이 된다.
 */
public class Solution1 {
    public static void main(String[] args) {
        //test 용~
        //[91, 92, 93, 94, 95, 96, 97, 98, 99, 100]
        int[] arr = {2,6,8,14};
        int[] arr2 = {1,2,3};

        System.out.println(solution(arr));
        System.out.println(solution(arr2));

    }

    public static long solution(int[] arr) {
        long answer = 0;

        //일단 동적 배열로 바꾸기
        List<Long> list = new ArrayList<>();
        for (long num : arr) {
            list.add(num);
        }

        //수 두개씩 보내서 최소 공배수를 구한다.
        //list안의 수가 한 개이면 멈춘다.
        while(list.size() > 1){
            long a = list.get(0);
            long b = list.get(1);
            long gcd = gcd(a, b); //짜피 뒤로 밀려나니까 하나씩만 보내면 된다~
            long lcd = lcd(a, b, gcd);

            list.remove(0); //지우는건 계속 지워야 맞음~
            list.remove(0);
            list.add(lcd); //새로운 최소 공배수 더하기~
        }

        answer = list.get(0); //이렇게 하면 하나 남았을 테니~

       return answer;
    }

    //최대 공약수를 구하는 메서드를 따로 둔다.
    public static long gcd(long a, long b){
        while(a % b != 0){
            long n = a;
            a = b;
            b = n % b; //이게 r인셈
        }
        return b;
    }
    //최소 공배수를 구하는 메서드
    public static long lcd(long a, long b, long gcd){
        return (a * b) / gcd;
    }
}
