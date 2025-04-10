#include <bits/stdc++.h>

using namespace std;

//Speed
#define fastio() ios_base::sync_with_stdio(false), cin.tie(nullptr), cout.tie(nullptr);

//Macros
#define all(x) x.begin(), x.end()
#define inint(x) int x; cin >> x;
#define out(x) cout << x << endl;
#define foreach(i, j, k, in) for(int i = j; i < k; i += in)
#define rep(i, j) foreach(i, 0, j, 1)

typedef vector<int> vi;
typedef vector<vi> vvi;
typedef long long ll;

void solve() {
    inint(n);
    inint(m);
    vvi c(n, vi(m));
    rep(i, n) rep(j, m) cin >> c[i][j];

    vi col[m];
    rep(i, n) rep(j, m) col[j].push_back(c[i][j]);

    ll ans = 0;

    rep(i, m) {
        sort(all(col[i]));
        rep(j, n) {
            ans += (ll)j * col[i][j] - (ll)(n - 1 - j) * col[i][j];
        }
    }
    out(ans);
}

int32_t main() {
    fastio();
    int t;
    cin >> t;
    while (t--) {
        solve();
    }
    return 0;
}
