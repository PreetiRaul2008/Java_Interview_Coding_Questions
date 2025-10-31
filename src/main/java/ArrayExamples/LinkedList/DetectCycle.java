package ArrayExamples.LinkedList;

public class DetectCycle {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;

        if(hasCycle(head)){
            System.out.println("Cycle detected in the LinkedList");
        }else{
            System.out.println("No Cycle detected in the LinkedList");
        }
    }

    public static boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
