import javafx.util.Pair;

public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    // 头节点
    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     * 在链表中不是一个常用的操作，练习用
     *
     * @param index 索引
     * @param e     添加的元素
     */
    @Deprecated
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        head = add(head, index, e);
        size++;


    }

    private Node add(Node node, int index, E e) {
        if (index == 0) {
            return new Node(e, node);
        }
        node.next = add(node.next, index - 1, e);
        return node;
    }

    /**
     * 在链表头添加新元素e
     *
     * @param e
     */
    public void addFirst(E e) {

//        Node node = new Node(e);
//        node.next = head;
//        head = node;

        add(0, e);

    }

    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表的第index(0-based)个位置的元素
     * 在链表中不是一个常用的操作，练习用:)
     *
     * @param index 索引
     * @return
     */
    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        return get(head, index);
    }

    private E get(Node node, int index) {
        if (index == 0) {
            return node.e;
        }
        return get(node.next, index - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * 修改链表的第index(0-based)个位置的元素
     * 在链表中不是一个常用的操作，练习用:)
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        set(head, index, e);
    }

    private void set(Node node, int index, E e) {

        if (index == 0) {
            node.e = e;
            return;
        }
        set(node.next, index - 1, e);
    }

    /**
     * 查找链表中是否有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {

        return contains(head, e);

    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        }
        return contains(node.next, e);
    }

    /**
     * 删除索引元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        Pair<Node, E> res = remove(head, index);
        size--;
        head = res.getKey();
        return res.getValue();
    }

    private Pair<Node,E> remove(Node node, int index) {
        if (index == 0) {
            return new Pair<>(node.next, node.e);
        }
        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getKey();
        return new Pair<>(node, res.getValue());
    }

    public E removeFitst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }

        for (Node cur = head; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int index = 5;
        while (index > 0) {
            linkedList.addFirst(index);
            index--;
        }
        System.out.println(linkedList);
        System.out.println(linkedList.remove(3));
        System.out.println(linkedList.get(3));
    }


}
