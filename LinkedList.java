package singlyLinkedList;
public class LinkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 1) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        current.next = current.next.next;
    }
    public void deleteAfterNode(int data) {
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            System.out.println("Node not found or no node after the given node");
            return;
        }
        current.next = current.next.next;
    }
    public boolean searchNode(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtPos(15, 1);
        list.insertAtPos(35, 2);
        list.insertAtPos(45, 3);
        list.insertAtPos(40, 3);
        list.display();
        list.deleteAtPosition(3);
        list.display();
        list.deleteAfterNode(35);
        list.display();
        System.out.println(list.searchNode(35));
        System.out.println(list.searchNode(45));
    }
}