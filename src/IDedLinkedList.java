public class IDedLinkedList<AnyType extends IDedObject> {
    private class Node {
        AnyType data;
        Node next;
        Node(AnyType d) { data = d; next = null; }
    }

    private Node head;

    public IDedLinkedList() {
        head = null;
    }

    // empties the list
    public void makeEmpty() {
        head = null;
    }

    // finds the item with the given id
    public AnyType findID(int ID) {
        Node current = head;
        while (current != null) {
            if (current.data.getID() == ID) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    // inserts at front
    public boolean insertAtFront(AnyType x) {
        if (findID(x.getID()) != null) {
            return false; // Duplicate ID
        }
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        return true;
    }

    // deletes from the front
    public AnyType deleteFromFront() {
        if (head == null) return null;
        AnyType temp = head.data;
        head = head.next;
        return temp;
    }

    // deletes with the id given
    public AnyType delete(int ID) {
        if (head == null) return null;

        if (head.data.getID() == ID) {
            AnyType temp = head.data;
            head = head.next;
            return temp;
        }

        Node prev = head;
        Node current = head.next;
        while (current != null) {
            if (current.data.getID() == ID) {
                prev.next = current.next;
                return current.data;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    // prints all of the items in the record
    public void printAllRecords() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            current.data.printID();
            current = current.next;
        }
    }
}
