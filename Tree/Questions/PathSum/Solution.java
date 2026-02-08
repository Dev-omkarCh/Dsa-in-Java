package PathSum;
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

    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        return countOfNodes(root.left) + countOfNodes(root.right) + 1;
    }

    public static boolean hasPathSum(Node root, int targetSum){

         /*
                1
               2   2
                3    3
        */

        int sum = 0;
        if(root == null){
            sum = 0;
            if(sum == targetSum){
                return true;
            }
            return false;
        }
        sum+= root.data;
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                return true;
            }
            return false;
        }
        if(root.left == null){
            hasPathSum(root.right, targetSum);
        }
        if(root.right == null){
            hasPathSum(root.left, targetSum);
        }

        boolean left = hasPathSum(root.left, targetSum);
        boolean right = hasPathSum(root.right, targetSum);

        return left || right;
    }

    public static void main(String[] args) {
        int[] t1 = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int[] t2 = {1,2,3,-1,-1,4,-1,-1,2,4,-1,-1,3,-1,-1};
        int[] t3 = {1,2,-1,3,-1,-1,2,-1,3,-1,-1};

        ArrayList<int[]> testcases = new ArrayList<>();
        testcases.add(t1);
        testcases.add(t2);
        testcases.add(t3);

        ArrayList<Node> roots = new ArrayList<>();

        for(int[] testcase : testcases){
            Build tree = new Build();
            roots.add(tree.build(testcase));
        }

        for(Node root : roots){
            System.out.println(hasPathSum(root, 6));
        }
    }
}
