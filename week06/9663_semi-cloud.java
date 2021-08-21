public class Main {
	static int N;
	static int[] chess;  //1차원 배열로
	static int queen;   //총 퀸 경우의 수

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		chess = new int[N];
		bt(0);
        System.out.println(queen);
	}
	
	public static void bt(int depth) {  //depth : 열
		if(depth == N) {
			queen++;
			return;
		}
		
		for(int i = 0; i < N; i++) {  // i : 행
			chess[depth] = i;   
			
			if(check(depth)) {   //해당 열에서, i번째 행에 채울수 있는가?
				bt(depth + 1);  	
			}
		}	
	}
	
	public static boolean check(int col) {

		for(int i = 0; i < col ; i++) { 
			//같은 열에 퀸이 있는지 check
			if(chess[col] == chess[i]) {  
				return false;
			}
			//대각선 방향에 퀸이 있을 경우
			//대각선 : 열의 차와 행의 차가 같을 경우
			else if(Math.abs(col - i) == Math.abs(chess[col] - chess[i])) {
				return false;
			}
		}
		return true;	
	}

}
