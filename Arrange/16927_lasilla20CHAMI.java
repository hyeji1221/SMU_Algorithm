import java.util.*;

public class Arr{

	static int N;
	static int M;
	static int rotate;
	static int[][] array;
  int rowS, rowE, colS, colE;
  
  public void Input(){
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
	
	public static void main(String[] args) {

		Input();
		rowS = colS = 0;
		rowE = N-1;
		colE = M-1;
    
		while(true) {
			int size = (rowE-rowS+1)*2 + (colE-colS+1)*2 -4;
			change(rowS,rowE,colS,colE,rotate%size);
			rowS += 1;
			rowE -= 1;
			colS += 1;
			colE -= 1;
			if(rowS>rowE || colS>colE) break;
		}
		
	public static void change(int rowStart, int rowEnd, int colStart, int colEnd, int cnt) {
		for(int k=0;k<cnt;k++) {
      //임시로 담아두기
			int temp = array[rowStart][colStart];

			for(int j=colStart;j<colEnd;j++) {
				array[rowStart][j] = array[rowStart][j+1]; 
			}//왼쪽 이동
			
			for(int i=rowStart;i<rowEnd;i++) {
				array[i][colEnd] = array[i+1][colEnd];
			}//위로 이동
			
			for(int j=colEnd;j>colStart;j--) {
				array[rowEnd][j] = array[rowEnd][j-1];
			}//오른쪽 이동
			
			for(int i=rowEnd;i>rowStart;i--) {
				array[i][colStart] = array[i-1][colStart];
			}//위로 이동
			array[rowStart+1][colStart] = temp;
		}
	}
    
  		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
}
