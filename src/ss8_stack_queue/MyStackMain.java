package ss8_stack_queue;

public class MyStackMain {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(10);
        stack.push(100);
        stack.push(1000);

        System.out.println("Stack: "+ stack.toString());

//        b Peek()
        Integer value = stack.peek();
        System.out.println(value);
//      c. pop()
        Integer pop = stack.pop();
        System.out.println(pop);
//        d. isEmpty
        boolean isEmpty = stack.isEmpty();
        System.out.println(" Stack is empty: : "+ isEmpty);
//        e. size()
        int size = stack.size();
        System.out.println(size);
    }
}
