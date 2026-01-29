public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null; // true is list is empty
    }

    /**
     * Adds a new node to the lined list
     * @param data - the String we are adding
     */
    public void add(String data) {
        Node node = new Node(data);// Make a new node object
        if (isEmpty()) { // if the list is empty this is the first item
            head = node;
            tail = node;
        } else { // otherwise add it to the tail
            tail.setNext(node); // What was the tail is now pointing to the new item
            tail = node; // the new item is now the tail
        }
    }

    public void print() {
        Node next = head;
        while (next != null) {
            System.out.println(next.getData());
            next = next.getNext();
        }
    }

    public String search(String item) {
        Node next = head;
        String itemFound = "";
        while (next != null) {
            if (next.getData().equals(item)) {
                itemFound = item;
            }
            next = next.getNext();
        }
        return itemFound;
    }

    /**
     * For your in class exercise explore completing the following methods for a Singly Linked list supported by
     * your tutor.
     *     // remove
     *     // replace
     *     // delete
     *     // add at head
     *     // menu
     * If you complete all of these save the code, copy  and refactor the entire project as a doubly linked list.
     */

}