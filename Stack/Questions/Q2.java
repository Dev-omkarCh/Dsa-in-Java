// Q. Reverse of Stack
import java.util.Stack;
public class Q2 {

     /*
        Approach :-
        Remove all elements from the stack one by one,
        when stack becomes empty, then
        Add the top element to the bottom of the Stack, one by one

    */

    /*
        input  = [5,4,3,2,1]
        output = [1,2,3,4,5] # reversed

        5(pop) -> 4(pop) -> 3(pop) -> 2(pop) -> 1(pop) 
        return -> pushAtBottom(1)
        return -> pushAtBottom(2)
        return -> pushAtBottom(3)
        return -> pushAtBottom(4)
        return -> pushAtBottom(5)
    
    */

    public static void pushAtBottom(int data, Stack<Integer> stack){
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(data, stack);
        stack.push(top);
    }

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int top = stack.pop();
        reverse(stack);
        pushAtBottom(top, stack);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        reverse(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
