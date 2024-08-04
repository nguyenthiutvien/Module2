package ss8_stack_queue.exercise2;

public class MyQueueMain {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.push(10);
        queue.push(100);
        queue.push(1000);

        System.out.println("Stack: " + queue.toString());

//        b Peek()
        Integer value = queue.peek();
        System.out.println(value);
//      c. pop()
        Integer pop = queue.poll();
        System.out.println(pop);
//        d. isEmpty
        boolean isEmpty = queue.isEmpty();
        System.out.println(" Stack is empty: : " + isEmpty);
//        e. size()
        int size = queue.size();
        System.out.println(size);
    }
}
