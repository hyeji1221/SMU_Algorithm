public class Main {

	static int N;
	static int K;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();    //값 담을 큐
		
		N = Integer.parseInt(st.nextToken());
	  K = Integer.parseInt(st.nextToken());
	    
	  for(int i = 1; i <= N ; i++) {
	    	q.add(i);
	  }
    
	  sb.append("<");  
	  while(q.size() != 1) {     //큐 사이즈가 1이 될때까지 반복
	    	
	    for(int i = 0; i < K-1 ; i++) {   //K-1까지 값을 꺼내고 바로 큐에 추가
	    		q.offer(q.poll());
	    }	   
	    sb.append(q.poll() + ", ");	    //K번째 값 꺼내기
	  }	    
	  sb.append(q.poll() + ">");   //큐 사이즈가 1이면 그냥 꺼내기
	  System.out.println(sb.toString());	   
	}
}
