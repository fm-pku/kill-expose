/**
 * Linked list node
 */
public class LNode {
    public int data;
    @Peer
    public LNode next;

    public LNode(int data) {
        this.data = data;
        this.next = null;
    }

    public void addBefore(LNode n) {
        n.next = this;
    }

    public void addAfter(LNode n) {
        n.next = this.next;
        this.next = n;
    }
}
