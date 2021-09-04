public class Main {
	static int N;    
	static boolean[] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new boolean[N+1];
	
    //상근이가 놓을 수 있는 자리 : true, 놓을 수 없는 자리 : false
		for(int i = 1; i <= N ; i++) {
			if(!dp[i-1]) {    //바로 전에꺼가 false이면 무조건 이번에 놓을 수 있음
				dp[i] = true;   
			}
			
			if(i-3 >= 0 && !dp[i-3]) {      
				dp[i] = true;
			}
		}
		
		if(dp[N]) { System.out.println("SK");}
		else {System.out.println("CY");}
	}
}
