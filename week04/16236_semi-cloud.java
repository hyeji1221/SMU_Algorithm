public class Main{
	
	static int N;
	static int M;
	static int move;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;        
  static int[] dx = {0,-1,0,1}, dy = {-1,0,1,0};  //좌 상 우 하
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		int x = 0;     //상어 시작 좌표
		int y = 0;
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			
				if(map[i][j] == 9) {   //아기 상어의 위치 저장
					  x = i; y = j;
				    map[i][j] = 0;    
				}
			}
		}		
		findSherk(x,y);		
	}
	
	
	public static void findSherk(int s, int e) {  
		int eat = 0;      //먹은 갯수
		int size = 2;     //상어 초기 크기
		int cur[] = new int[] {s,e};  //현재 위치 담을 배열
		boolean check = false;      //먹이를 먹었는지 여부
		
		while(true) {	
      //우선 순위 큐 사용
			q = new PriorityQueue<>((o1, o2) -> {    
				if(o1[2] == o2[2]) {               //둘이 거리가 같은경우
					if(o1[0] == o2[0]) {              //x 좌표가 같은 경우(높이가 같음)
					   return Integer.compare(o1[1], o2[1]);     //y좌표가 더 작은게 왼쪽
					}
					return Integer.compare(o1[0], o2[0]);       //x좌표가 더 작은게 위쪽
				}
				return Integer.compare(o1[2], o2[2]);          
			});
      
		  visit = new boolean[N][N];     
		  check = false;                     
		    
			q.add(new int[] {cur[0], cur[1], 0});     //시작 위치 삽입
			visit[cur[0]][cur[1]] = true;             //시작 위치 방문 표시
                  
			while(!q.isEmpty()) {     
				cur = q.poll();
	
        //1. 먹이를 먹을 수 있는 경우
				if(map[cur[0]][cur[1]] < size && map[cur[0]][cur[1]] != 0) {  
					map[cur[0]][cur[1]] = 0;      //물고기 제거
					check = true;   
					move += cur[2];               //지금까지 이동한 거리 더하기
					eat++;
					break;
				}
	
				for(int i = 0; i < 4; i++) {  
					int nx = cur[0] + dx[i];          
					int ny = cur[1] + dy[i];

					if(nx < 0 || nx >= N || ny < 0 || ny >= N || visit[nx][ny] ) {continue;}   
													
					//2. 이동만 가능한 경우
					if(map[nx][ny] <= size) {
						q.add(new int[]{nx, ny, cur[2] + 1});     //최단 거리 후보만 큐에 추가(이전 거리 + 1)
						visit[nx][ny] = true;				
					}					
				}				
			}
			
			if(!check) { break;}    //더이상 먹을 먹이가 없으므로 종료
			
			if(eat == size) {       //크기와 먹은 물고기 수가 같으면 사이즈 증가
				size++;        
				eat = 0;    
			}				
		}
		System.out.println(move);		
	}
}
