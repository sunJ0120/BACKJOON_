package swea;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    public static void main(String args[]) throws Exception
    {
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
        //System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int[] profit;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {

            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
				 이 부분에 여러분의 알고리즘 구현이 들어갑니다.

                 중요한건, 최고가일때 전부 판매하고
                 최고가 전에 뭐가 없으면 판매하지 않는 것이다.
                 일단 증가할 때까지 증가 시킨 다음에,
                 그 전에 있던 것들을 하나씩 더해서 최고가 * 전에 있던 인덱스 이렇게 하면 된다.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////
            int t =sc.nextInt();
            boolean tf = false;
            int start = 0;
            int ans = 0;
            profit = new int[t];
            for(int i = 0; i<t;i++){
                profit[i] = sc.nextInt();
            }
            for(int j = 1; j< t;j++){
                if(tf){ //true인 상태에서 - 일단, 시작이 작은거
                    if(profit[j-1] > profit[j]){ //이럴 경우 최댓값을 찍은 것이다
                        for(int z = start; z < j-1; z++){ //j == t-1 -> j가 마지막일 경우
                            ans += (profit[j-1]-profit[z]);
                        }
                    }
                    if(j == t-1){ //끝까지
                        for(int z = start; z < j; z++){
                            ans += (profit[j]-profit[z]);
                        }
                    }
                }

                if(profit[j-1] > profit[j]) {  1 1 3 1 2
                    start = j;
                    tf = false;
                }else{
                    tf = true;
                }
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}
