import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {

    private static int[] dx = {0, 1, 0, -1}; //우 하 좌 상 방향 설정
    private static int[] dy = {1, 0, -1, 0};
    private static int n, l, k;
    private static int[][] board;
    private static List<int[]> snake;
    
    public static void main(String[] args) { 
        snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        k = sc.nextInt(); 
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x - 1][y - 1] = 1; // 사과의 위치 설정
        }
        l = sc.nextInt(); 
        int[][] dir = new int[l][2];
        for (int i = 0; i < l; i++) {
            dir[i][0] = sc.nextInt();
            char temp = sc.next().charAt(0); 
            dir[i][1] = (temp == 'L') ? -1 : 1; // 왼쪽이면 -> -1, 오른쪽이면-> 1
        }
        
        solution(0, 0, 0, dir);
    }
    
    private static int solution(int cx, int cy, int currentDir, int[][] dir) { 
        int time = 0; int turn = 0;
        while (true) {
            time++;                           //한 칸당 1초씩 증가
            int nx = cx + dx[currentDir];       // 다음 위치 = 현재 + dx[방향]
            int ny= cy + dy[currentDir];
            
            if (isFinish(nx, ny)) break;
            
            if (board[nx][ny] == 1) {    // 사과를 먹으면
                snake.add(new int[]{nx, ny});    //다음 노드를 연결리스트에 추가
                board[nx][nY] = 0;      //*****[백준]사과를 먹었다는 표시 해줘야 오류가 x
            }
            else { snake.add(new int[]{nx, ny});   //사과를 먹지 않으면
                  snake.remove(0);                 //경로 추가 후snake 꼬리 제거하기 
            }
            cx = nx; cy = ny;             //현재 노드 변경
            
            if (turn < l) {
                if (time == dir[turn][0]) {                    //1초씩 증가하다가 방향전환하는 시간이 오면
                    currentDir = nextDir(currentDir, dir[turn][1]);   //방향 재설정하고 전환하기
                    turn++; }
            }
        }
        System.out.println(time);
    } 
    
    private static int nextDir(int current, int dir) {
        int next = (current + dir) % 4;       //다음 방향 = (현재 방향 + 전환해야하는 방향) % 4
        if (next == -1) next = 3;             
        return next;
    }
    
    private static boolean isFinish(int x, int y) {
        //종료 조건 체크하는 함수
        if (x == -1 || x == n || y == -1 || y == n) { // 다음 위치가 보드판 밖으로 나갔는지
            return true; } 
            
        for (int i = 0; i < snake.size(); i++) { // 뱀 몸통이랑 닿았는지 
           if(x == snake.get(i)[0] && y == snake.get(i)[1]){
				        return true;        
        }
        return false; 
    } 
}
