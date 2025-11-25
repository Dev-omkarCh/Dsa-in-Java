import java.util.Stack;

// Using Inbuild Stack from Java
class MyStack{
    public static void main(String[] args){
        Stack<String> stack = new Stack<String>();

        stack.push("Minecraft");
        stack.push("RLCraft");
        stack.push("SpiderMan");

        while (!stack.isEmpty()) {
            System.out.println();
        };
    };
}