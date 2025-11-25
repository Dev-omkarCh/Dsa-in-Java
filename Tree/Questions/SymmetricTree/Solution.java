package SymmetricTree;

import java.util.ArrayList;

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

    public static int count(Node root){
        if(root == null){
            return 0;
        }
        return count(root.left) + count(root.right) + 1;
    }

    public static boolean isMirror(Node left, Node right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        return left.data == right.data && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static boolean isSymmetric(Node root){
        if(root == null){
            return false;
        }
        return isMirror(root.left, root.right);
    }

    public static void main(String[] args) {

        ArrayList<int[]> testcases = new ArrayList<>();

        int[] t1 = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int[] t2 = {1,2,3,-1,-1,4,-1,-1,2,4,-1,-1,3,-1,-1};
        int[] t3 = {1,2,-1,3,-1,-1,2,-1,3,-1,-1};

        testcases.add(t1);
        testcases.add(t2);
        testcases.add(t3);

        ArrayList<Node> roots = new ArrayList<>();

        for(int[] testcase : testcases){
            Build tree = new Build();
            roots.add(tree.build(testcase));
        }

        for(Node root : roots){
            System.out.println(isSymmetric(root));
        }
    }
}