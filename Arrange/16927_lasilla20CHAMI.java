import java.util.*;
public class Main {

	static int N;
	static int M;
	static int rotate;
	static int[][] array;
	
    public static void Input(){
        //입력 받기
        Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		rotate = sc.nextInt();
		array = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				array[i][j] = sc.nextInt();
			}
		}
    }
    
    public static void prt(){
        //출력 하기
        for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
    }
    
	public static void main(String[] args) {
		Input();
        //각 행, 열 범위 지정
		int rowS = 0;
		int rowE = N-1;
		int colS = 0;
		int colE = M-1;

		while(true) {
			int size = (rowE-rowS+1)*2 + (colE-colS+1)*2 -4;
            //rotate%size만큼 돌림(최소화 하기)
			change(rowS,rowE,colS,colE,rotate%size);
            //start와 end를 한 칸씩 이동
			rowS+=1;
			rowE-=1;
			colS+=1;
			colE-=1;
            //만약 start지점이 end를 넘으면 종료
			if(rowS>rowE || colS>colE) break;
		}
        prt();
	}
	
	public static void change(int rowS, int rowE, int colS, int colE, int cnt) {
        //cnt만큼 반복
		for(int k=0;k<cnt;k++) {
            //임시로 저장
			int temp = array[rowS][colS];
            
			for(int j=colS;j<colE;j++) {
				array[rowS][j] = array[rowS][j+1]; 
			}//왼쪽 이동
			
			for(int i=rowS;i<rowE;i++) {
				array[i][colE] = array[i+1][colE];
			}//위로 이동
			
			for(int j=colE;j>colS;j--) {
				array[rowE][j] = array[rowE][j-1];
			}//오른쪽 이동
			
			for(int i=rowE;i>rowS;i--) {
				array[i][colS] = array[i-1][colS];
			}//아래 이동
            		//저장했던 것 옮김
			array[rowS+1][colS] = temp;
		}
	}

}
