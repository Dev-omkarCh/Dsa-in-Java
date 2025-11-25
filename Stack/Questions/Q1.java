// Q. Push at the Bottom of Stack

import java.util.Stack;

public class Q1 {

    // Rescurion

    /*
        Two types of Stacks :-
        1. Implicit Stack (Resucrsion Stack/ memory)
        2. Explicit Stack (Memory we made i.e classes)(Stack, java.util.Stack)
    */

    /*
        Approach :-
        Remove all elements from the stack one by one,
        when stack becomes empty, then
        Add the element, then
        Keep adding the element one by one

    */

    /*
        4(pop) -> 3(pop) -> 2(pop) -> 1(pop) 
        5(push)
        return -> 1(push)
        return -> 2(push)
        return -> 3(push)
        return -> 4(push)
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

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        pushAtBottom(5, stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        };
    }
}
