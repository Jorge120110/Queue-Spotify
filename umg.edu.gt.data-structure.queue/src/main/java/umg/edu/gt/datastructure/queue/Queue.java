package umg.edu.gt.datastructure.queue;

public class Queue<T> {
    // Nodo interno privado para no exponer la implementación
    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head; // Frente de la cola (para extraer)
    private Node<T> tail; // Final de la cola (para insertar)
    private int size;

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // O(1) - Insertar al final
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Remover del frente
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        T data = head.data;
        head = head.next;
        size--;
        
        if (isEmpty()) {
            tail = null;
        }
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}