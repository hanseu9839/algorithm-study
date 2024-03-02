# 프로그래머스 길찾기
[link](https://school.programmers.co.kr/learn/courses/30/lessons/42892)

````````
import java.util.*;

class Solution {
    int[][] answer;
    static int idx =0;
    static class Node {
        int x;
        int y;
        int value;
        Node left;
        Node right;
        public Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        answer = new int[2][nodeinfo.length];
        for(int i=0;i<nodeinfo.length; i++){
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null,null);
        }
        Arrays.sort(nodes, new Comparator<Node>(){
           public int compare(Node a, Node b){
               if(a.y == b.y) {
                   return a.x - b.x;
               }
               return b.y - a.y;
           } 
        });
        
        Node parent = nodes[0];
        
        for(int i=1;i<nodes.length;i++){
            makeTree(parent, nodes[i]);
        }
        
        
        preOrder(parent);
        idx = 0;
        postOrder(parent);
        return answer;
    }
    
    public void makeTree(Node parent, Node child){
        if(parent.x < child.x) {
            if(parent.right == null) {
                parent.right = child;
            } else {
                makeTree(parent.right, child);
            }
        } else {
            if(parent.left == null) {
                parent.left = child;
            } else {
                makeTree(parent.left, child);
            }
        }
    }
    
    public void preOrder(Node root){
        if(root!= null){
            answer[0][idx++] = root.value;
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
    public void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            answer[1][idx++] = root.value;
        }
    }
}
````````