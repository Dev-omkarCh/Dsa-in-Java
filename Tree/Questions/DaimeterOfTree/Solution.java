package DaimeterOfTree;
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
    /*
    Number of Nodes in the Longest path between any 2 nodes

    1. Case : Through root

             ↑ (1) ↓
              /  \
          ↑ (2)  (3) ↓
           / \     \
        ↑(4) (5)   (6) ↓

        longest = 4 -> 2 -> 1 -> 3 -> 6
        longest = 5
    
    2. Case : Without Going Through root

                   (1) 
                   /
               ↑ (2) ↓
                 / \     
             ↑ (4) (5) ↓   
               /     \
           ↑ (6)     (7) ↓

        longest = 6 -> 4 -> 2 -> 5 -> 7
        longest = 5

    */

    /*
        Approach 1 : O(n^2)
    
            1
           / \
          2   3
         / \   \
        4  5    6
    
        Three cases for it
        1. Daimeter exists in left subtree i.e [2,4,5]. No root needed
        2. Daimeter exists in right subtree i.e [3,6]. No root needed
        3. Daimeter exists in : left + right + 1 i.e [1,2,3,4,5,6]. Includes root

        Approch 2 : O(n)

        Just Calulate height at the same time as Daimeter

        

    */

    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }

    // O(n^2)
    public static int daimeterOfTree(Node root){
        if(root == null){
            return 0;
        }

        int daim1 = daimeterOfTree(root.left);
        int daim2 = daimeterOfTree(root.right);
        int daim3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(daim3, Math.max(daim1, daim2));
    }

    public static class TreeInfo{
        int daim;
        int height;

        TreeInfo(int daim, int ht){
            this.daim = daim;
            this.height = ht;
        }
    }

    // O(n)
    public static TreeInfo diameter(Node root){

        if(root == null){
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter(root.left);
        TreeInfo right = diameter(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int daim1 = left.daim;
        int daim2 = right.daim;
        int daim3 = left.height + right.height + 1;

        int myDaim = Math.max(Math.max(daim1, daim2), daim3);

        TreeInfo myInfo = new TreeInfo(myDaim, myHeight);
        return myInfo;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Build tree = new Build();
        Node root = tree.build(nodes);
        System.out.println(daimeterOfTree(root));
        System.out.println(diameter(root).daim);
    }
}
