package HeightOfTree;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    Node left;
    Node right;
    int data;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Build{
    public int index = -1;

    public Node build(int[] nodes){
        index++;
        if(nodes[index] == -1){
            return null;
        }

        Node root = new Node(nodes[index]);
        root.left = build(nodes);
        root.right = build(nodes);
        return root;
    };
}

public class Solution {

    // levelOrder Vise
    public static int heightOfTreeByMe(Node root){
        Queue<Node> queue = new LinkedList<>();
        int height = 1;
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node curNode = queue.remove();
            if(curNode == null){
                if(queue.isEmpty()){
                    return height;
                }
                else{
                    queue.add(null);
                    height++;
                }
            }
            else{
                if(curNode.left != null) queue.add(curNode.left);
                if(curNode.right != null) queue.add(curNode.right);
            }
        }
        return height;
    }

    // Recursively O(n)
    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }

    /*
            1
           / \
          2   3
         / \   \
        4  5    6
    */

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Build tree = new Build();
        Node root = tree.build(nodes);
        System.out.println(heightOfTree(root));
    }
}
