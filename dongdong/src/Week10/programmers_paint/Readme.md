# 덧칠하기
[link](https://school.programmers.co.kr/learn/courses/30/lessons/161989)

## 문제 풀이
1. 오름차순으로 이미 정렬되어 있으니 현재 s 값에서 m을 더하면 next이고 이때, next가 section에서 가져온 값보다 크다면 continue로 넘어간다.
````````
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int next = 0;
        for(int s : section){
            if(next > s) continue;
            next = s+m;
            answer++;
        }
        return answer;
    }
}
````````