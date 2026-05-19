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

    //remove
    public void remove(String item){

        if(head == null){
            System.out.println("Invalid");
        }
        
        if(head.getData().equals(item)){
                head = head.getNext();
                size--;
            }

        Node curr = head.getNext();
        Node prev = head;

        while(curr != null){
            if(curr.getData().equals(item)){
                prev.setNext(curr.getNext());
                curr = prev.getNext();
                size--;
            }
            else{
                prev = curr;
                curr = curr.getNext();  
            }

        }
    }

    //replace
    public boolean replace(String oldItem, String newItem){
        Node curr = head;
        while(curr != null){
            if(curr.getData().equals(oldItem)){
            curr.setData(newItem);
            return true;
        }
        else{
            curr = curr.getNext();
        }
        }
        return false;
    }

    //delete
    public void delete(int index){
        int counter = 1;
        
        if(index>=0 && index < size){
            if(index == 0){
                head = head.getNext();
                size--;
                return;
            }
            Node prev = head;
            Node curr = head.getNext();
            while(counter != index){
                counter++;
                prev = curr;
                curr = curr.getNext();
            }
            prev.setNext(curr.getNext());
            size--;
        }
    }

    //add at head
    public void addAtHead(String data){
        Node newHead = new Node(data);
        newHead.setNext(head);
        head = newHead;
    }

    //menu
        public void menu() {

        try (Scanner input = new Scanner(System.in)) {
            while (true) {

                System.out.println("\n--- LINKED LIST MENU ---");
                System.out.println("1. Add item (head)");
                System.out.println("2. Remove item");
                System.out.println("3. Search item");
                System.out.println("4. Replace item");
                System.out.println("5. Delete by index");
                System.out.println("6. Print list");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");

                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter item: ");
                        addAtHead(input.nextLine());
                        break;

                    case 2:
                        System.out.print("Enter item to remove: ");
                        remove(input.nextLine());
                        break;

                    case 3:
                        System.out.print("Enter item to search: ");
                        System.out.println(search(input.nextLine()));
                        break;

                    case 4:
                        System.out.print("Old item: ");
                        String oldItem = input.nextLine();
                        System.out.print("New item: ");
                        String newItem = input.nextLine();
                        replace(oldItem, newItem);
                        break;

                    case 5:
                        System.out.print("Enter index: ");
                        delete(input.nextInt());
                        input.nextLine();
                        break;

                    case 6:
                        print();
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }

}
