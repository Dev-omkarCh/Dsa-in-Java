package HeightOfTree;
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

    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);
        return Math.max(left, right) + 1;
    }

    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int left = countOfNodes(root.left);
        int right = countOfNodes(root.right);
        return left + right + 1;
    }

    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int left = sumOfNodes(root.left);
        int right = sumOfNodes(root.right);
        return left + right + root.data;
    }

    public static int  diameterOfTree(Node root){
        if(root == null){
            return 0;
        }
        int daim1 = diameterOfTree(root.left);
        int daim2 = diameterOfTree(root.right);
        int daim3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
        int daimeter = Math.max(Math.max(daim1, daim2), daim3);
        return daimeter;
    }


    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Build tree = new Build();
        Node root = tree.build(nodes);
        System.out.println(diameterOfTree(root));
    }
}