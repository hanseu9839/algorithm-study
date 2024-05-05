def solve():
    def fibonaci(n):
        if dp[n]:
            return dp[n]

        ans = [0, 0]
        if n == 0:
            ans[0] += 1
        elif n == 1:
            ans[1] += 1
        else:
            val1 = fibonaci(n - 1)
            ans[0] += val1[0]
            ans[1] += val1[1]
            val2 = fibonaci(n - 2)
            ans[0] += val2[0]
            ans[1] += val2[1]

        dp[n] = ans
        return ans

    dp = [[] for _ in range(41)]
    N = int(input())
    for _ in range(N):
        num = int(input())
        answer = fibonaci(num)
        print(" ".join(map(str, answer)))


solve()
