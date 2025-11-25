package SumOfNodes;
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

    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Build tree = new Build();
        Node root = tree.build(nodes);
        System.out.println(sumOfNodes(root));
    }
}