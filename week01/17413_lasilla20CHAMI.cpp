#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(void) {
	string voca;
	getline(cin, voca);
	/*cin은 공백(띄어쓰기)가 올 시 입력이 끝난 것으로 간주한다.
	string의 getline은 엔터(\n)를 인식해서 그 전까지의 입력값을 문자열로 저장
	*/
	int n = (int)voca.length();

	for (int i = 0; i < n; i++) {

		if (voca[0] == '>' || voca[0] == ' ' || voca[n] == ' ') {
			return 0;
		}

		if (voca[i] == '<') {
			int idx = i;
			while (voca[idx] != '>')
				idx++;
			i = idx;
			//태그 부분은 뛰어넘기
		} //태그가 아니라면,
		else if (voca[i] != ' ') {
			int x = i; //단어 뒤집을 시작 위치 저장
			while (voca[x] != ' ' && voca[x] != '<' && voca[x] != '\0') {
				x++;
			}
			string temp = voca.substr(i, x - i);
			reverse(temp.begin(), temp.end()); //추출한 단어를 뒤집기
			voca.replace(voca.begin() + i, voca.begin() + i + (int)temp.length(), temp);
			//시작은 begin()+i, 뒤집을 단어의 갯수만큼 범위 지정. 뒤집은 단어 끼워넣기
			i = x - 1;
			//반복문에서 i가 ++되므로 -1한 값을 i에다 지정
		}
	}
	cout << voca << '\n';
	return 0;
}
