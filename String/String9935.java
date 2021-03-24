import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class String9935 {
    static String origin;  //���ڿ� : ���ĺ� + ����
    static String bomb;
    static String find;
 //  static char[] s;
  //  static int a;    //�ε��� ���� ��ġ
    
    //static Stack<String> st;  //�и� ���ڿ� ���� ����
    
	public static void main(String[] args) throws IOException{
		//���� ���ڿ� : p�� �Ҷ�, 
		//s �ȿ� p�� ���ԵǾ� ������ ���p ���󰡰� ���� s �̾���̱�
		//��� p�� s�� ���������� ���� �ݺ�, but ���� ���� ���ڿ��� p�� ���ԵǾ� �������� �ִ�
		//ó�� ������ p����=> ���̱� => ����ؼ� p ����
		//1.s.contains()���
		//p���� �տ� ���ڿ��ϰ� �ڿ� ���ڿ��� ���ÿ� �־��=> ������ �˻��ϰ� ���ԵǾ������� �ٽ� �и� =>
		
		//mirkovC4nizCC44
		//(������� ���� �ݺ���)
		//mirkov
		//nizCC44
		
		//mirkovnizCC44
		
		//mirkovnizC
		//4
		
		//mirkovnizC4
		
		//mirkovniz
		
		//���� 4 + nizC ��ü => nizC4 => ���� niz
		//���� mikrov + niz => mikrovniz
		//���ÿ� ������ �ڿ� �и��� ���ڿ� ���� ������ �Ǳ� �ϴµ� ..��.
		/*
		 *1. �켱 �Է¹��� ���ڿ�(input)�� �Ųٷ� Stack�� �־��ش�

          2. Stack�� �� ���ھ� �־��� ������ top�� ��ź ���ڿ�(bomb)�� ù���ڿ� ���Ѵ�.
           2-1. ù���ڰ� ������ �� ���� ���ڸ� ���ؼ� bomb�� ���� �������� Ȯ���Ѵ�.

           2-2. ���� ���ڰ� �ƴϸ� isBomb�� false�� �ǰ�,

           2-3. bomb�� �Ϻ��ϰ� ���ٸ�(isBomb==true) bomb�� ���̸�ŭ stack���� pop�� �����ش�.

   �� �̷��� ���ڰ� �ϳ��� ���� ������ check���ָ� �Ѳ����� �ְ� Ȯ���ϴ� �ͺ��� �ξ� ȿ�����̴�
          3. ��ź�� ���� �Ͷ߸��� ���  
         //������ ����ϸ� ���ÿ��� POP, PUSH �ϴ� �������� �ð��� �޸𸮸� ���� ��ƸԾ� ==> char�迭�� �̿��ؼ� ����!
		 */
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		origin = bf.readLine();
		bomb = bf.readLine();
	
		find = delete_bomb(origin, bomb);
		//�� ���ڿ��̸�  ������ ������ FRULA ���
		System.out.println(find.length() == 0 ? "FRULA" : find);
	}
	
	public static String delete_bomb(String s, String bomb ) {  //���ڰ� ��ź���� üũ(�ϳ��� ������ �κ� üũ�س�����)
		char[] result = new char[s.length()];
		int idx = 0;
		
		for(int i = 0; i < s.length() ;i++) {
			result[idx] = s.charAt(i);   //�ϳ��� ����Ʈ�� ���� �ֱ�
			if(isBomb(result, idx, bomb)) {   //result �迭�� ��ź�� ���������(�� �ְ��� ����)
				idx -= bomb.length();
			}
			idx++;    //���ڰ� ��ź�� �ƴϸ� ����ؼ� ���� ���� ����ֱ�
		}
		
		//result.toString() �ϸ� �ȵ��� �� ũ�⸸ŭ ���ڰ� ��� ���� �����ϱ�
		return String.valueOf(result, 0, idx);
	}
	
	public static boolean isBomb(char[] result, int idx, String bomb) {
		
		if(idx < bomb.length() - 1) {return false;}  //��ź ���ڿ� ���̺��� ������ false����
		for(int i = 0; i < bomb.length() ; i++) {
			//���� �ε��� - ��ź ���̸�ŭ ���� ó�� ���ں��� �񱳰���
			//���ڰ� �ٸ��� false ����
			if(bomb.charAt(i) != result[idx - bomb.length() + 1 + i]) { return false;}
		}
		return true;
	}
}
		
		/*
		st.push(origin);    //���� ���ڿ� ���ÿ� �߰�
		while(!st.isEmpty()) {  //������ �������� �ݺ�
			
			String s = st.pop();  //������ �ϳ� ���� ��, 
			//������ ���ԵǾ� �ִ� ���ڿ��̸� ���ÿ� �߰�, �Ϸ�ȰŸ� ���ÿ��� ��������?
			if(is_contain(s, bomb)) { //a�� ����Ǿ� �־�
				
				String s1 = s.substring(0, a ); //���ڿ� �и�
				String s2 = s.substring(a + bomb.length() , s.length());

				st.push(s2);
				st.push(s1);  //�տ����� ���߿� �ֱ�
				
			}else {    //�����ԵǾ� ������ �Ϸ�� �κ� ���ڿ� , ���߿� ���� ����� ���ڿ��� ���̱⤿ =>x, ���ڿ� ���� �ٿ��� �ٽ� ������?
				//�ϳ��� ���Ƽ� �� ���Ұ� ������
				if(st.size() >= 1) {   //�̹� �տ��� �ϳ� �������ϱ� �ϳ��� �����������Ƴ�
					find = s + st.pop();
					st.push(find);
				}	
				//�����ִ� ���ڰ� ���� ��찡 �ִ�. �̶��� "FRULA"��
			}
		}
		
		if(find.isBlank()) {System.out.println("FRULA");}
		else {System.out.println(find);
		}
			
		
	}
	
	//���ڰ� ���ԵǾ� �ִ��� ���� ������ġ�ϰ� ��ȯ
    //�޸� �ʰ� ����? ===> 1���� ũ�ų� ����, 1,000,000
	public static boolean is_contain(String s, String p) {
		
		
		a = s.indexOf(p);  //�� Ư�� ������ ���� �ε��� ��ȯ

		//�ش� ���ڿ� �����ϰ� ������
		if(a > -1) { return true;}
		else { return false;}
	}
}
*/