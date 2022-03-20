package main.java;

public class FixedCapacityStack<T> {

    private Object[] array;

    private int size;

    public FixedCapacityStack(int size) {
        // construct a array with given size.
        array = new Object[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return this.size;
    }

    public void push(T object) {
        if (this.size != array.length) {
            array[size++] = object;
        } else {
            throw new ArrayIndexOutOfBoundsException("reach end of this stack.");
        }

    }

    public T pop() {
        return (T) array[--size];
    }

    public static void main(String[] args) {
        try {
            FixedCapacityStack<String> fixedCapacityStack = new FixedCapacityStack<>(4);
            System.out.println("is the stack empty? " + fixedCapacityStack.isEmpty());
            fixedCapacityStack.push("1");
            fixedCapacityStack.push("2");
            System.out.println("the size of this stack is: " + fixedCapacityStack.getSize());
            System.out.println("return value: " + fixedCapacityStack.pop());
            fixedCapacityStack.push("2");
            fixedCapacityStack.push("3");
            fixedCapacityStack.push("4");
            fixedCapacityStack.push("5");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out of Bounds Exception happened.");
        }

    }

}
