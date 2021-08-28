public class Main {
	static int T;
	static String[] command = {"D","S","L","R"}; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q;	
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());  

	    for(int i = 0; i < T ; i++) {
	      q = new LinkedList<>();
	      String[] result = new String[10000];    //결과 문자열 담을 배열
	    	boolean[] visit = new boolean[10000];   //방문 체크 배열
	    	
	    	st = new StringTokenizer(br.readLine());
	    	int a = Integer.parseInt(st.nextToken());
	    	int b = Integer.parseInt(st.nextToken());
	    	
	    	//BFS
	    	q.add(a);    
	    	visit[a] = true;
	      Arrays.fill(result, "");   //배열 초기화
	        
	    	while(!q.isEmpty() && !visit[b]) {   //목표 지점을 방문하지 않았다면 반복
	    		int cur = q.poll();            //현재 숫자
	    				    		
	    		for(int j = 0; j < 4 ; j++) {      
	    			int num = calculate(cur, command[j]);    //명령어로 계산된 숫자
	    
	    			if(!visit[num]) {           //계산된 숫자를 방문하지 않다면, 큐에 추가
	    				q.add(num);
		    		  visit[num] = true;
		    		  result[num] = result[cur] + command[j];  //명령어 결과값에 추가
	    			}
	    		}
	    	}
	    	
	    	System.out.println(result[b]);	      
	    }	
	}
	
	//명령어에 따른 계산 처리
	public static int calculate(int n, String s) {
		if(s == "D") {
			return (2*n) % 10000;
			
		}else if(s == "S") {
			if(n == 0) { return 9999;}
			return n-1;	
			
		}else if(s == "L") {     //왼쪽 이동
			return (n % 1000) * 10 + n/1000; 
			
		}else if(s == "R") {     //오른쪽 이동
			return (n % 10)* 1000 + n/10;  	
		}
		return 0;
	}
}
