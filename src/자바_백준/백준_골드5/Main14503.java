package 자바_백준.백준_골드5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
있는 그대로 구현하면 된다.

- 북, 동, 남, 서 ((0,-1),(1,0),(0,1),(-1,0))
- 회전할때는 반시계니까 -1한 인덱스를 구하되, 0일 경우 (마이너스) -> 3으로
- 한 칸 후진 : (방향-2)의 절댓값

💣 이거 너무 혼자 힘으로 못풀었고 풀이도 맘에 안들어...반드시 다시 정리하고 자기.
 */
public class Main14503 {
    static int[][] NESW = {{0,-1},{1,0},{0,1},{-1,0}}; //북동남서, x,y
    static int rotation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int ans = 0;

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] stage = new int[r][m];

        //로봇 좌표
        st = new StringTokenizer(br.readLine());
        int robotY = Integer.parseInt(st.nextToken()); //💣 이미 인덱스로 주어지고 있으므로 -1 하면 안된다.
        int robotX = Integer.parseInt(st.nextToken()); //💣 이미 인덱스로 주어지고 있으므로 -1 하면 안된다.
        rotation = Integer.parseInt(st.nextToken());

        //방 정보 넣기
        for(int i = 0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<m; j++){
                stage[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            //현재 내 위치에서 청소가 가능한지 먼저 보기
            if(clean(robotY, robotX, stage) == 2){
                stage[robotY][robotX] = 2; //청소 완료
                ans++;
            }else{ //현재 내 위치 청소 되어 있음
                //4방향 탐구
                //📌 이미 지나간 곳에서 검사하면 안 된다.
                int go = rotation;
                boolean moved = false;
                for(int i = 0; i<4; i++){
                    go = (go + 3) % 4; //📌 왼쪽 회전 방향 구하는 식이 잘못됐음.

                    int isClean = clean(robotY + NESW[go][1], robotX + NESW[go][0], stage);
                    if(isClean == 2){ //이동한 위치사 청소 가능 + 움직이기 가능
                        rotation = go; //방향 변환
                        robotY += NESW[rotation][1];
                        robotX += NESW[rotation][0];
                        moved = true;
                        break;
                    }
                }

                if(!moved){
                    // rotation 은 절대 바꾸지 않고, back 이라는 임시 변수만 써야한다. 방향이 바뀌는게 아니다.
                    int back = (rotation + 2) % 4; //📌 후진해야 하는 방향 구하는 식이 잘못됐음.
                    // 💣 여기서 벽이든 뭐든 일단 뒤로 가버리는게 문제다.
                    int backY = robotY + NESW[back][1];
                    int backX = robotX + NESW[back][0];

                    if(clean(backY, backX, stage) == 0){
                        break; //바로 종료
                    }else{
                        //아닐 경우 한 칸 이동한다.
                        robotY = backY;
                        robotX = backX;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    //청소용 메서드
    public static int clean(int y, int x, int[][] stage){
        if(stage[y][x] == 0){
            return 2;
        }else if(stage[y][x] == 2){ //청소는 되어 있음. 지나갈 순 있다.
            return 1; //지나갈 순 있음
        }
        return 0;
    }
}
