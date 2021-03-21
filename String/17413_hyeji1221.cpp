#include <iostream>
#include <string>
#include <stack>
using namespace std;

stack<char> field;
bool stack_flag = true; // stack 이용 표시
string str;

string print_stack() {
    string ret;
    while (!field.empty()) {
        ret += field.top();
        field.pop();
    }
    return ret;
}

int32_t main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    getline(cin, str); // 공백 포함 입력 받기
    str += ' ';
    for (auto chr : str) {
        if (chr == '>') {
            cout << chr;
            stack_flag = true;
        }
        else if (chr == '<') {
            cout << print_stack();
            stack_flag = false;
            cout << chr;
        }
        else if (stack_flag) {
            if (chr == ' ') {
                cout << print_stack() << ' ';
            }
            else {
                field.push(chr);
            }
        }
        else {
            cout << chr;
        }
    }

    return 0;
}
