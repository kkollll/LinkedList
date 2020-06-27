import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * 双端链表
 *
 * @author Wr
 */
public class DoubleEndsLinkedList<E> implements Serializable {

    transient Node<E> first;
    transient Node<E> last;
    transient int size = 0;

    private class Node<E> {

        private Node prev;
        private Node next;
        private E e;

        public Node(Node prev, Node next, E e) {
            this.prev = prev;
            this.next = next;
            this.e = e;
        }

    }

    public void add(int index, E e) {
        checkPositionIndex(index);

        if (index == size) {
            linkedLast(e);
        } else {
            linkedBefore(e, node(index));
        }
    }

    private Node<E> node(int index) {
        checkPositionIndex(index);
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> y = last;
            for (int i = size - 1; i > index; i--) {
                y = y.prev;
            }
            return y;
        }
    }

    private void linkedBefore(E e, Node<E> succ) {
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, succ, e);
        succ.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    private void linkedLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, null, e);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;

    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node<E> next = first;
        for (; ; ) {
            if (next == null) {
                sb.append("]");
                return sb.toString();
            } else {
                sb.append(next.e);
                if (next.next != null) {
                    sb.append(", ");
                }
                next = next.next;
            }
        }
    }
}
