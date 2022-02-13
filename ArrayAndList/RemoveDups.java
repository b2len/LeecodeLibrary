import java.util.HashSet;
import java.util.LinkedList;

public class RemoveDups {
    public static void removeDups(LinkedList head) {
        Node curr = head;
        while (curr.next != null) {
            Node runner = curr;
            while (curr.next != null) {
                if (curr.val == runner.next.val) { // if the fast pointer's next node have the same value of current
                                                   // node
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            curr = curr.next;
        }
    }

    public static void removeDupsHash(LinkedList head) {
        HashSet set = new HashSet();
        LinkedList prev = null;
        while (head != null) {
            if (set.contains(head.val)) {
                prev = head.next;
            } else {
                set.add(head.data);
                prev = head;
            }
            head = head.next;
        }
    }

}
