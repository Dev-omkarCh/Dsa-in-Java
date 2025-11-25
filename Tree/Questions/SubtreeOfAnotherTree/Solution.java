package SubtreeOfAnotherTree;

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

    public static int subtreeOfAnotherTree(Node root){
        /*
            
            class Solution {

                public boolean isIdentical(TreeNode root, TreeNode subRoot){
                    if(root == null && subRoot == null){
                        return true;
                    }
                    if(root == null || subRoot == null){
                        return false;
                    }
                    if(root.val == subRoot.val){
                        return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right)
                    }
                    return false;
                }

                public boolean isSubtree(TreeNode root, TreeNode subRoot) {
                    if(subRoot == null){
                        return true;
                    }
                    if(root == null){
                        return false;
                    }

                    if(root.val == subRoot.val){
                        if(isIdentical(root, subRoot)){
                            return true;
                        }
                    }

                    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)

                }
            }
        */
    
        return 0;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Build tree = new Build();
        Node root = tree.build(nodes);
        System.out.println(subtreeOfAnotherTree(root));
    }
}