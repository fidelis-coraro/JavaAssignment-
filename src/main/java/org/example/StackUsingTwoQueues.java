package org.example;
import java.util.LinkedList;
import java.util.Queue;
// Custom exception for an empty stack
class StackEmptyException extends Exception { public StackEmptyException(String message) {super(message);}}
public class StackUsingTwoQueues {
    // Two queues for implementing stack
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    // Constructor to initialize the stack
    public StackUsingTwoQueues() {queue1 = new LinkedList<>();queue2 = new LinkedList<>();}

    // Push element to the top of the stack
    public void push(int data) {queue2.add(data);// Add the new element to queue2

        // Transfer all elements from queue1 to queue2
        while (!queue1.isEmpty()) {queue2.add(queue1.remove());}

        // Swap the names of the queues
        Queue<Integer> temp = queue1;queue1 = queue2;queue2 = temp;}// Now, queue1 holds the stack elements in the correct order

    // Pop element from the top of the stack
    public int pop() throws StackEmptyException {if (queue1.isEmpty()) {throw new StackEmptyException("Stack is empty");}return queue1.remove();} // Remove the front element from queue1 (top of the stack)

    // Get the top element of the stack without removing it
    public int top() throws StackEmptyException {if (queue1.isEmpty()) {throw new StackEmptyException("Stack is empty");}return queue1.peek();} // Return the front element from queue1 (top of the stack)

    // Check if the stack is empty
    public boolean isEmpty() {return queue1.isEmpty();}

    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();

        // Testing the stack functionality
        try {
            stack.push(10);stack.push(20);stack.push(30);

            System.out.println("Top element: " + stack.top());  // Should print 30
            System.out.println("Pop element: " + stack.pop());  // Should remove and print 30
            System.out.println("Top element after pop: " + stack.top());  // Should print 20
            System.out.println("Is stack empty? " + stack.isEmpty());  // Should print false
            System.out.println("Pop element: " + stack.pop());  // Should remove and print 20
            System.out.println("Pop element: " + stack.pop());  // Should remove and print 10
            System.out.println("Is stack empty? " + stack.isEmpty());  // Should print true
            // Attempt to pop from an empty stack (this will throw an exception)
            stack.pop();
        } catch (StackEmptyException e) {System.out.println(e.getMessage());}
    }
}

