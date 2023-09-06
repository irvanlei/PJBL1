public class Stack<T> {
    private Object[] array;
    private int size;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.size = 0;
    }

    public void push(T item) {
        if (size == capacity) {
            capacity *= 2;
            Object[] newArray = new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size++] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        T item = (T) array[--size];
        array[size] = null;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
