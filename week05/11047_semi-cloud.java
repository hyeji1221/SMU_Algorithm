public class Main {
	static int n = 0;
    static int k = 0;
    static int coinVal[];
    static int minCoin;   

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());    //금액이 서로 다른 동전의 갯수
		k = Integer.parseInt(st.nextToken());    //동전의 합
		coinVal = new int[n];
		
		for(int i = 0; i < coinVal.length; i++) {	//동전 종류 입력 	
			coinVal[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i = n - 1; i >=0 ; i--) {
			
			if(coinVal[i] <= k) {
				//현재 가치의 동전으로 구성할 수 있는 개수 더해주기
				minCoin += (k / coinVal[i]);
				k %= coinVal[i];
			}
        }	
		System.out.println(minCoin);
		
	}
}
