package b.StacksAndQueues;

public class Test {
    public static void main(String[] args) {
        Stack stack = new Stack();
        StackArray stackArray = new StackArray(2);
        stack.push("1");
        stack.pop();
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(3);
        System.out.println(stackArray.pop() + " " + stackArray.pop() + " " + stackArray.pop() + " " + stackArray.pop());
        QueueArray qa = new QueueArray(2);
        qa.put(1);
        qa.put(2);
        qa.put(3);
        System.out.println(qa.poll() + " " + qa.poll() + " " + qa.poll());
    }
}
