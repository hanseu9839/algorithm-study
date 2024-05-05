import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def solve():
    def topological_sort(building):
        if max_times[building] > 0:
            return max_times[building]

        time = costs[building]
        for adj in dependencies[building]:
            time = max(time, topological_sort(adj) + costs[building])
        max_times[building] = time
        return max_times[building]

    N, K = map(int, input().rstrip().split())
    costs = [0] + list(map(int, input().rstrip().split()))
    dependencies = [[] for _ in range(N + 1)]
    for _ in range(K):
        a, b = map(int, input().rstrip().split())
        dependencies[b].append(a)  # 목적지에 필요한 경로**

    TARGET = int(input())
    max_times = [0] * (N + 1)
    topological_sort(TARGET)
    print(max_times[TARGET])


T = int(input())
for _ in range(T):
    solve()
