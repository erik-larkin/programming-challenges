import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {

    private static Queue<Integer> queue;

    public static void main(String[] args) {
		QueueUsingTwoStacks solution = new QueueUsingTwoStacks();
        queue = solution.new Queue<Integer>();
        
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
                
        for (int i = 0; i < q; i++) {
            int query = scanner.nextInt();
            switch (query) {
                case 1:
                    int item = scanner.nextInt();
                    queue.enqueue(item);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
                default:
                    break;
            }
        }
        scanner.close();
    }
    
    private class Queue<T> {
        private Stack<T> enqueueStack;
        private Stack<T> dequeueStack;
        
        public Queue() {
            enqueueStack = new Stack<T>();
            dequeueStack = new Stack<T>();
        }
        
        public void enqueue(T item) {
            enqueueStack.push(item);
        }
        
        public T dequeue() {   
            if (dequeueStack.isEmpty())
                swapStacks(enqueueStack, dequeueStack);
                
            return dequeueStack.pop();
        }
        
        public T peek() {   
            if (dequeueStack.isEmpty())
                swapStacks(enqueueStack, dequeueStack);

            return dequeueStack.peek();
        }
        
        private void swapStacks(Stack<T> fromStack, Stack<T> toStack) {
            while (!fromStack.isEmpty()) {
                toStack.push(fromStack.pop());
            }
        }
    }
}