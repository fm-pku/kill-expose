/**
 * Linked list
 */
public class LList {
    @Rep
    public LNode head;  /* rep */

    public LList() {
        head = null;
    }

    public int length() {
        int len = 0;
        for (LNode n = this.head; n != null; n = n.next) {
            len += 1;
        }
        return len;
    }

    public int sum() {
        int s = 0;
        for (LNode n = this.head; n != null; n = n.next) {
            s += n.data;
        }
        return s;
    }

    public void add(int x) {
        LNode n = new LNode(x);
        if (head != null)
            head.addBefore(n);
        head = n;
    }

    public void show() {
        for (LNode n = head; n != null; n = n.next) {
            System.out.println(n.data);
        }
        System.out.println();
    }

    static public void main(String[] args) {
        LList a = new LList();
        a.add(2);
        a.add(3);
        a.add(5);
        a.add(7);
        int len = a.length();
        a.show();
        if (len > 2) {
            LNode n = a.head.next.next;
            n.data *= 2;
        } else {
            a.head.data -= 5;
        }
        int s = a.sum();
        a.show();
        System.out.printf("sum = %d\n", s);
    }
}
