package 자바_백준.개념;

public class Dijkstra_1 {

    static int number = 6;
    static int INF = 10000000;

    static int[][] a = new int[][]{
        {0,2,5,1,INF, INF},
        {2,0,3,2,INF, INF},
        {5,3,0,3,1,5},
        {1,2,3,0,1,INF},
        {INF, INF,1,1,0,2},
        {INF, INF,5,INF,2,0},
    };

    static boolean[] v = new boolean[6]; //방문 여부를 나타냄
    static int[] d = new int[6]; //출발점에서 ~ 거리를 나타냄

    //가장 작은 인덱스를 내보내는
    public static int getSmallIndex(){
        int min = INF;
        int index = 0;
        for(int i = 0; i<number; i++){
            if(d[i] < min && !v[i]){ //min 보다 작고, 방문한 적 없는 경우
                min = d[i]; //최소 정점을 갱신
                index = i; //최소에 해당하는 인덱스 저장
            }
        }
        return index;
    }

    //다익스트라 알고리즘
    public static void dijkstra(int start){
        for(int i = 0; i < number; i++){
            d[i] = a[start][i]; //start에서 정점에 갈때를 정리
        }

        v[start] = true;
        for(int i = 0; i<number-2; i++){ //inf를 빼고 돌리기 위해 num-2이다.
            int current = getSmallIndex();
            v[current] = true; //가장 작은 정점을 true로 만든다.
            for(int j = 0; j<6; j++){
                if(!v[j]){ //j를 방문한 적 없음
                    //지금 있는 것보다, 작은거 선택한거 + 작은거에서 -> j갈때가 더 작다면 갱신.
                    if(d[current] + a[current][j] < d[j]){
                        d[j] = d[current] + a[current][j];
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        dijkstra(0);
        for(int i =0; i<number; i++){
            System.out.println(d[i]);
        }
    }
}
