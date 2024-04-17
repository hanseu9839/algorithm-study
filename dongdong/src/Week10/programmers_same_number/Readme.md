# 같은 숫자는 싫어
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/12906)

1. 이전 값이 같다면 들어가지 않기 때문에 prev를 선언해주어 비교해주고 같다면 continue 
2. 아니라면 ArrayList에 넣어주었다. 
``````
import java.util.*;

public class Solution {
    public ArrayList<Integer>solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int prev=-1;
        for(int i=0;i<arr.length;i++){
            if(i>0) prev = arr[i-1];
            if(prev == arr[i]) continue;
            answer.add(arr[i]);
            
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
``````
## 다른 사람 풀이
````
import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(arr[0]);
        for(int i=1; i<arr.length;i++){
            if(arr[i]!=list.getLast()){
                list.add(arr[i]);
            }

        }
        Integer[] listing = list.toArray(new Integer[list.size()]);
        int []answer =Arrays.stream(listing).mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
````
시간 복잡도의 효율은 좋지 않지만 람다식에 대한 이해를 하기 위해서는 좋은 것 같음.
