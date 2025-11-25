public class LinkedListStack {
    public static class Node{
        int data;
        Node next;

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        };

        public Node(int data){
            this.data = data;
            this.next = null;
        };
    }

    public static class Stack{
        public static Node head;

        public boolean isEmpty(){
            return head == null;
        };

        public void push(int data){
            Node newNode = new Node(data);
            if(this.isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public int pop(){
            if(this.isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek(){
            if(this.isEmpty()){
                return -1;
            }
            return head.data;
        }
    }
    
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    };
}
