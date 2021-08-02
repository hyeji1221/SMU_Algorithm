import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int cnt;  //명령어의 개수
	static Stack<Character> lst; //왼쪽 문자열 스택
	static Stack<Character> rst; //오른쪽 문자열 스택
	public static void main(String[] args) throws IOException {

 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringBuilder str = new StringBuilder(br.readLine());
		lst = new Stack<>(); rst = new Stack<>();

        for(int i = 0; i< str.length();i++) { //왼쪽 문자열 스택에 문자 추가
        	lst.add(str.charAt(i));
        }
		
	  cnt = Integer.parseInt(br.readLine());
		for(int i = 0; i < cnt ; i++) { //전체 명령어의 수만큼 동작    
			String cmd = br.readLine();    //명령어 입력받기
			if(cmd.contains("P"))         
				lst.push(cmd.charAt(2));    //커서 왼쪽에 문자 추가
			else {
				switch(cmd) {
				case "L": 
					if(!lst.isEmpty())
						rst.push(lst.pop());   //커서 왼쪽 이동
					break;
				case "D": 
					if(!rst.isEmpty())
						lst.push(rst.pop());   //커서 오른쪽 이동
					break;
				case "B": 
					if(!lst.isEmpty())  
						lst.pop();             //커서 왼쪽 문자 삭제
					break;
				}
			}
		}
    StringBuilder sb = new StringBuilder();
		while(!lst.isEmpty()) {rst.add(lst.pop());}  //문자열 오른쪽 문자열 스택으로 합치고 출력
		while(!rst.isEmpty()) {sb.append(rst.pop());}
		System.out.println(sb);
	}

}
