#include <iostream>
using namespace std;
long long dp[101][101];
int jump[101][101];

int main(void){
    int n;
    cin >> n;
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            int t; cin >> t;
            //입력 조건
            if(t<0 || t>9) return 0;
            jump[i][j] = t;
        }
    }
    
    //처음 시작 지점의 방법수 =1 
    dp[1][1] = 1;
    
    for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
            //시작 지점은 셀 필요 X
            if(i == 1 && j == 1) continue;
             
            //오른쪽으로 점프
            for(int k = 1; k < j; k++) {
                if(k + jump[i][k] == j) {
                    dp[i][j] += dp[i][k];
                }
            }
            //아래로 점프
            for(int k = 1 ; k < i ; k++) {
                if(k + jump[k][j] == i) {
                    dp[i][j] += dp[k][j];
                }
            }
        }
    }
    cout << dp[n][n] << '\n';
}
