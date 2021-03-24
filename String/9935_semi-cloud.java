import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class String9935 {
    static String origin;  
    static String bomb;
    static String find;
	
	public static void main(String[] args) throws IOException{
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
