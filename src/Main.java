public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 5; i > 0; i--) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 555);
        System.out.println(linkedList);

        System.out.println(linkedList.get(5));

        System.out.println(linkedList.getSize());

        System.out.println(linkedList.isEmpty());

        System.out.println(linkedList.remove(2));

        System.out.println(linkedList);

        System.out.println(linkedList.removeFitst());

        System.out.println(linkedList);

        System.out.println(linkedList.removeLast());

        System.out.println(linkedList);
    }
}
