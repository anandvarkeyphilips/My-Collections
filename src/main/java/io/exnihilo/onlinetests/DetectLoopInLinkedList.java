package io.exnihilo.onlinetests;

public class DetectLoopInLinkedList {
    public static void main(String[] args) {
        LinkedListReverse linkedListReverse = new LinkedListReverse();
        //LinkedListReverse.Node node =(linkedListReverse).Node(1); wont work

        LinkedListReverse.Node node = new LinkedListReverse.Node(1);
        node.next = new LinkedListReverse.Node(2);
        node.next.next = new LinkedListReverse.Node(3);
        node.next.next.next = new LinkedListReverse.Node(4);
        node.next.next.next.next = new LinkedListReverse.Node(5);
        node.next.next.next.next.next = new LinkedListReverse.Node(6);
        node.next.next.next.next.next.next = node.next;

        //linkedListReverse.printList(node);
        LinkedListReverse.Node nodeLoop = detectLoop(node);
        System.out.println(nodeLoop.data);
    }

    public static LinkedListReverse.Node detectLoop(LinkedListReverse.Node node) {
        LinkedListReverse.Node fast = node.next;
        while (fast != null && node != fast.next.next) {
            node = node.next;
            fast = fast.next.next;
        }
        return node;
    }

}
