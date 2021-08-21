public class Main {
	static int N;
	static long[][] dp;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		dp = new long[N][N];
		arr = new int[N][N];
		
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		dp[0][0] = 1;      //시작점 초기화
		for(int i = 0; i < N ; i++) {   
			for(int j = 0; j < N ; j++) {   
				
				if(i == N-1 && j == N-1) {break;}  //종착점에서는 계산 X
				
				int next = arr[i][j];        //이동가능한 칸 수
				if(i + next < N) {          //아래쪽 방향으로 이동가능한 경우
					dp[i+next][j] += dp[i][j] ;      //현재 지점까지 이동가능한 경로의 수 더하기
				}
				
				if(j + next < N ) {         //오른쪽 방향으로 이동가능한 경우
					dp[i][j+next] += dp[i][j] ;
				}			
			}
		}		
		System.out.println(dp[N-1][N-1]);	    //종점까지 총 이동가능한 경로 출력
	}
}
