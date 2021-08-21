public class Main {
	static int n;  //스위치 개수
	static int student; //학생 수
	static int[] arr;  //스위치 상태

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		student = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < student; i++) { 
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			
			//남자 인 경우
			if(num == 1) {
				for(int j = 1; j <= n ; j++) {
					if(j % index == 0) {      //배수인 경우 스위칭
						arr[j] = 1 - arr[j];
					}
				}		
			}
			//여자인 경우
			else{
		        int l = index - 1;
				    int r = index + 1;
            arr[index] = 1- arr[index];    //현재 위치 바꾸기
                  
            while(l > 0 && r <= n) {
                if(arr[l] == arr[r]) {      //대칭일 경우 스위칭
                    arr[l] = 1 - arr[l];
                    arr[r] = 1 - arr[r];
                    l--;
                    r++;
                }else {break;}
            }
			}	
		}
		
		for(int i = 1; i <= n ; i++) {    //한 줄에 20개씩 출력
			sb.append(arr[i]);
			sb.append(" ");
			
			if(i % 20 == 0) {
				sb.append("\n");
			}
		}		
		System.out.println(sb.toString());
	}
}
