## 프로그래머스 - 괄호 변환
## [link](https://school.programmers.co.kr/learn/courses/30/lessons/60058)

## 문제 풀이 
1. 균형잡힌 괄호 문자열 => "(" ")"의 개수를 말한다. 
2. 올바른 괄호 문자열이다. 괄호 쌍 ( )을 만족하는 상태를 말한다.  , 우리가 아는 괄호의 짝이 맞지 않기 때문에 올바른 괄호 문자열이 아니다. 

문제에서는 문자열은 균형잡힌 괄호 문자열이며, 이를 올바른 괄호 문자열로 변환하는게 핵심 문제이다. 

````
import java.util.*;

class Solution {
    public String solution(String p) {
        if(check(p)) return p;
        else return dfs(p);
    }
    
    private static boolean check(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '(') st.add(c);
            else {
                if(st.isEmpty()) return false;
                else st.pop();
            }
        }
        if(!st.isEmpty()) return false;
        else return true;
        
        
    }
    
    private static String dfs(String s) {
        if(s.length() == 0 ) return s;
        
        String u = "", v = "";
        int cnt1 = 0, cnt2 = 0;
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == '(') cnt1++;
            else cnt2++;
            
            if(((cnt1>0) && (cnt2 > 0)) && (cnt1 == cnt2) ) {
                u = s.substring(0, i + 1);
                if(i < s.length() - 1) v = s.substring(i+1, s.length());
                break;
            } 
        }
        
        if (check(u)) return u + dfs(v);
        else {
            // 4
            String tmp = "(" + dfs(v) + ")";
            u = u.substring(1, u.length() - 1);
            u = u.replace("(", ".");
            u = u.replace(")", "(");
            u = u.replace(".", ")");
            tmp = tmp + u;
            return tmp;
        }
    }
}
````