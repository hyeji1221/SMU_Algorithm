#include <iostream>
#include <list>
using namespace std;
list<char> li;
list<char>::iterator it;

int main() {
	char ch;
	int m;

	while ((ch = getchar()) != '\n') { li.push_back(ch); } //개행문자가 아닐 때까지 입력을 받음
	it = li.end();
	scanf("%d", &m);

	for (int a=0; a<m; a++) {
		scanf(" %c", &ch); //띄어쓰기를 안하면 출력 초과가 뜨는데 왜 그런진 모르겠다
		if (ch == 'L') { //커서 왼쪽으로 이동
			if (it != li.begin()) it--;
		}
		else if (ch == 'D') { //커서 오른쪽으로 이동
			if (it != li.end()) it++;
		}
		else if (ch == 'B') { //문자 삭제
			if (it == li.begin()) continue;
			it--;
			it = li.erase(it);
		}
		else { //추가할 문자를 받음
			scanf(" %c", &ch);
			it = li.insert(it, ch);
			it++;
		}
	}
	for (it = li.begin(); it != li.end(); it++) { printf("%c", *it); } //출력
}
