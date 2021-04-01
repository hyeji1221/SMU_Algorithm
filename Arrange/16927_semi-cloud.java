import java.util.*;
import java.io.*;

public class Main {
	public static final int[] dx = {1,0,-1,0};
	public static final int[] dy = {0,1,0,-1};
	
	public static int visit[][];
	public static int map[][];
	public static int N,M, time;
	public static int before, after, depth, dir =0;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		time = sc.nextInt();
		map = new int[N][M];
		visit = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				visit[i][j] = -1;
			}
		}
		
		for (int i = 0; i < N; i++) {
 			for (int j = 0; j < M; j++) {
                                //방문했으면 스킵
				if(visit[i][j] >= 0) continue;
				
				int num = ((N-1-(depth*2))*2) +((M-1-(depth*2))*2);
                                //4x4라고 가정할때 12회 반복하면 한바퀴를 도는 것과 같음
				if(time%num != 0) num = time%num;
				                                                                                        
				
				for (int k = 0; k < num; k++) {
					before = map[i][j];
					dir = 0;
					dfs(i,j);
				}
				depth++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
	
	public static void dfs(int row, int col) {
		
		if(visit[row][col] == -1) visit[row][col] = depth;
		
		int nx = row + dx[dir];
		int ny = col + dy[dir];
		
		if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
			dir++;
			if(dir > 3) return;
			
			nx = row + dx[dir];
			ny = col + dy[dir];
			
		}else if(visit[nx][ny] != depth && visit[nx][ny] != -1) {
			//자신의 깊이가 아니면서 방문하지 않은곳도 아닐때 (남의 깊이)
			dir++;
			if(dir > 3) return;
			
			nx = row + dx[dir];
			ny = col + dy[dir];
		}
	
		after  = map[nx][ny];
		map[nx][ny] = before;
		before = after;
		
		dfs(nx,ny);
	}
}
