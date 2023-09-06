public class Queue<T> {
    private Object[] array;
    private int size;
    private int capacity;
    private int front;
    private int rear;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = -1;
    }

    public void enqueue(T item) {
        if (size == capacity) {
            capacity *= 2;
            Object[] newArray = new Object[capacity];
            for (int i = 0; i < size; i++) {
                newArray[i] = array[(front + i) % size];
            }
            array = newArray;
            front = 0;
            rear = size - 1;
        }
        rear = (rear + 1) % capacity;
        array[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        T item = (T) array[front];
        array[front] = null;
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}