package Leetcode;

// leetcode - 2043
// tc - O(1), sc - O(n)
class Bank {
    long[] account;
    int n;
    public Bank(long[] balance) {
        int n = balance.length;
        this.n = n;
        account = new long[n+1];
        for(int i = 0; i < n; i++){
            account[i+1] = balance[i];
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1 <= 0 || account1 > n || account2 <= 0 || account2 > n || money > account[account1]) return false;
        account[account1] -= money;
        account[account2] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if(account <= 0 || account > n) return false;
        this.account[account] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account <= 0 || account > n) return false;
        if(this.account[account] >= money){
            this.account[account] -= money;
            return true;
        }
        return false;
    }
}
