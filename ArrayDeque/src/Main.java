import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int numElements = 1000000;


        long startTime = System.currentTimeMillis();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < numElements; i++) {
            stack.push("Element " + i);
        }
        while (!stack.isEmpty()) {
            stack.pop();
        }
        long endTime = System.currentTimeMillis();
        long stackTime = endTime - startTime;


        startTime = System.currentTimeMillis();
        Deque<String> linkedListDeque = new LinkedList<>();
        for (int i = 0; i < numElements; i++) {
            linkedListDeque.push("Element " + i);
        }
        while (!linkedListDeque.isEmpty()) {
            linkedListDeque.pop();
        }
        endTime = System.currentTimeMillis();
        long linkedListTime = endTime - startTime;


        startTime = System.currentTimeMillis();
        Deque<String> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < numElements; i++) {
            arrayDeque.push("Element " + i);
        }
        while (!arrayDeque.isEmpty()) {
            arrayDeque.pop();
        }
        endTime = System.currentTimeMillis();
        long arrayDequeTime = endTime - startTime;


        System.out.println("Время для Stack: " + stackTime + " мс");
        System.out.println("Время для Deque (LinkedList): " + linkedListTime + " мс");
        System.out.println("Время для Deque (ArrayDeque): " + arrayDequeTime + " мс");
    }
}
