import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class String9935 {
    static String origin;  //문자열 : 알파벳 + 숫자
    static String bomb;
    static String find;
 //  static char[] s;
  //  static int a;    //인덱스 시작 위치
    
    //static Stack<String> st;  //분리 문자열 담을 스택
    
	public static void main(String[] args) throws IOException{
		//폭발 문자열 : p라 할때, 
		//s 안에 p가 포함되어 있으면 모든p 날라가고 남은 s 이어붙이기
		//모든 p가 s에 없을때가지 폭발 반복, but 새로 새인 문자열에 p가 포함되어 있을수도 있다
		//처음 나오는 p제거=> 붙이기 => 계속해서 p 제거
		//1.s.contains()사용
		//p기준 앞에 문자열하고 뒤에 문자열을 스택에 넣어놔=> 꺼내서 검사하고 포함되어있으면 다시 분리 =>
		
		//mirkovC4nizCC44
		//(여기부터 스택 반복문)
		//mirkov
		//nizCC44
		
		//mirkovnizCC44
		
		//mirkovnizC
		//4
		
		//mirkovnizC4
		
		//mirkovniz
		
		//이후 4 + nizC 합체 => nizC4 => 제거 niz
		//이후 mikrov + niz => mikrovniz
		//스택에 넣을때 뒤에 분리된 문자열 부터 넣으면 되긴 하는데 ..음.
		/*
		 *1. 우선 입력받은 문자열(input)을 거꾸로 Stack에 넣어준다

          2. Stack에 한 글자씩 넣어줄 때마다 top을 폭탄 문자열(bomb)의 첫글자와 비교한다.
           2-1. 첫글자가 같으면 그 다음 문자를 비교해서 bomb와 같은 글자인지 확인한다.

           2-2. 같은 글자가 아니면 isBomb는 false가 되고,

           2-3. bomb와 완벽하게 같다면(isBomb==true) bomb의 길이만큼 stack에서 pop을 시켜준다.

   → 이렇게 글자가 하나씩 들어올 때마다 check해주면 한꺼번에 넣고 확인하는 것보다 훨씬 효율적이다
          3. 폭탄을 전부 터뜨리고 출력  
         //스택을 사용하면 스택에서 POP, PUSH 하는 과정에서 시간과 메모리를 많이 잡아먹어 ==> char배열을 이용해서 구현!
		 */
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		origin = bf.readLine();
		bomb = bf.readLine();
	
		find = delete_bomb(origin, bomb);
		//빈 문자열이면  문제의 조건인 FRULA 출력
		System.out.println(find.length() == 0 ? "FRULA" : find);
	}
	
	public static String delete_bomb(String s, String bomb ) {  //글자가 폭탄인지 체크(하나씩 나머지 부분 체크해나가기)
		char[] result = new char[s.length()];
		int idx = 0;
		
		for(int i = 0; i < s.length() ;i++) {
			result[idx] = s.charAt(i);   //하나씩 리설트에 집어 넣기
			if(isBomb(result, idx, bomb)) {   //result 배열에 폭탄이 들어있으면(다 넣고나서 제거)
				idx -= bomb.length();
			}
			idx++;    //글자가 폭탄이 아니면 계속해서 다음 글자 집어넣기
		}
		
		//result.toString() 하면 안되지 그 크기만큼 글자가 들어 있지 않으니까
		return String.valueOf(result, 0, idx);
	}
	
	public static boolean isBomb(char[] result, int idx, String bomb) {
		
		if(idx < bomb.length() - 1) {return false;}  //폭탄 문자열 길이보다 작으면 false리턴
		for(int i = 0; i < bomb.length() ; i++) {
			//현재 인덱스 - 폭탄 길이만큼 빼면 처음 글자부터 비교가능
			//글자가 다르면 false 리턴
			if(bomb.charAt(i) != result[idx - bomb.length() + 1 + i]) { return false;}
		}
		return true;
	}
}
		
		/*
		st.push(origin);    //원본 문자열 스택에 추가
		while(!st.isEmpty()) {  //스택이 빌때까지 반복
			
			String s = st.pop();  //마지막 하나 남고 팝, 
			//패턴이 포함되어 있는 문자열이면 스택에 추가, 완료된거면 스택에서 꺼내지마?
			if(is_contain(s, bomb)) { //a에 저장되어 있어
				
				String s1 = s.substring(0, a ); //문자열 분리
				String s2 = s.substring(a + bomb.length() , s.length());

				st.push(s2);
				st.push(s1);  //앞에꺼를 나중에 넣기
				
			}else {    //안포함되어 있으면 완료된 부분 문자열 , 나중에 최종 출력할 문자열에 붙이기ㅏ =>x, 문자열 끼리 붙여서 다시 놔야해?
				//하나만 남아서 더 팝할게 없으면
				if(st.size() >= 1) {   //이미 앞에서 하나 팝했으니까 하나만 남아있을꺼아녀
					find = s + st.pop();
					st.push(find);
				}	
				//남아있는 문자가 없는 경우가 있다. 이때는 "FRULA"를
			}
		}
		
		if(find.isBlank()) {System.out.println("FRULA");}
		else {System.out.println(find);
		}
			
		
	}
	
	//글자가 포함되어 있는지 묻고 시작위치하고 반환
    //메모리 초과 이유? ===> 1보다 크거나 같고, 1,000,000
	public static boolean is_contain(String s, String p) {
		
		
		a = s.indexOf(p);  //그 특정 문자의 시작 인덱스 반환

		//해당 문자열 포함하고 있으면
		if(a > -1) { return true;}
		else { return false;}
	}
}
*/