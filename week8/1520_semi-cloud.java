public class Main {
	static int n; 
	static int m;  
	static int map[][];
	static int dp[][];
	static int[] dx = {-1, 1, 0, 0 }; static int[] dy = {0, 0 ,-1, 1}; 
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		dp = new int[n+1][m+1];

		for(int i = 1; i <= n ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;                //-1로 초기화하여 방문하지 않은 경로인 0과 구분
			} 
		}
	    
		System.out.println(dfs(1,1));

	}
	public static int dfs(int x, int y) {
	
		if(x == n && y == m ) {    //마지막 노드까지 무사히 도달하면 경로 증가시키고 재귀 종료
			return 1;
		}
		
		if(dp[x][y] == -1) {		 // 경로의 수가 계산된 적 없고, 방문한 적 없는 경우만 계산
			dp[x][y] = 0;          // 방문 체크     
			 
			for(int i = 0; i < 4 ; i++) {    
	
				int x1 = x + dx[i];
				int y1 = y + dy[i];
				
				if(x1 < 1 || y1 < 1 || x1 >n || y1 >m) {continue;} 
				
				if(map[x1][y1] < map[x][y]) {   //방문하지 않은 노드와 현재노드보다 작은 노드에 대해서만 재귀로 탐색에 추가
					 dp[x][y] += dfs(x1, y1);      
				}
			}
		}else {
			return dp[x][y];
		} 
		return dp[x][y];  
	}
}
