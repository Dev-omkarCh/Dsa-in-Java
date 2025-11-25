package BalancedBinaryTree;

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

class TreeInfo{
    int ht;
    boolean bal;
    TreeInfo(boolean bal, int ht){
        this.ht = ht;
        this.bal = bal;
    }
}

public class Solution {

    public static int[] dfs(Node root){
        if(root == null) return new int[]{1,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balance = left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1;
        return new int[]{balance ? 1 : 0 , 1 + Math.max(left[1], right[1])};
    }

    public static TreeInfo heightAndBal(Node root){
        if(root == null) return new TreeInfo(true,0);

        TreeInfo left = heightAndBal(root.left);
        TreeInfo right = heightAndBal(root.right);

        boolean bal = left.bal && right.bal && Math.abs(left.ht - right.ht) <= 1;

        return new TreeInfo(bal, Math.max(left.ht, right.ht));
    }

    public static boolean isBalanced(Node root){
        return heightAndBal(root).bal;
    }

    public static int count(Node root){
        if(root == null){
            return 0;
        }
        return count(root.left) + count(root.right) + 1;
    }

    public static void main(String[] args) {

        ArrayList<int[]> testcases = new ArrayList<>();

        int[] t1 = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int[] t2 = {3,9,-1,-1,20,15,-1,-1,7,-1,-1};
        int[] t3 = {1,2,3,4,-1,-1,4,-1,-1,3,-1,-1,2,-1,-1};
        int[] t4 = {1,2,2,3,-1,-1,3,4,-1,-1,4,-1,-1,-1,-1};
        // int[] t5 = {-1};

        testcases.add(t1);
        testcases.add(t2);
        testcases.add(t3);
        testcases.add(t4);
        // testcases.add(t5);

        ArrayList<Node> roots = new ArrayList<>();

        for(int[] testcase : testcases){
            Build tree = new Build();
            roots.add(tree.build(testcase));
        }

        for(Node root : roots){
            System.out.println(isBalanced(root));
        }
    }
}
