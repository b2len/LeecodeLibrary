class MyLinkedList {

    class node {
        public int val;
        public node next;

        public node() {
            this.val = 0;
            this.next = null;
        }

        public node(int val) {
            this.val = val;
            this.next = null;
        }

        public node(int val, node next) {
            this.val = val;
            this.next = next;
        }

    }

    private node head;
    private node tail;
    private int size;

    public MyLinkedList() {
        this.head = this.tail = null;
        this.size = 0;
    }

    private node getNode(int index) {
        node n = new node(0, this.head);
        while (index-- >= 0) {
            n = n.next;
        }
        return n;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        return getNode(index).val;
    }

    public void addAtHead(int val) {

        this.head = new node(val, this.head);
        if (this.size++ == 0)
            this.tail = this.head;
        this.size++;

    }

    public void addAtTail(int val) {
        node n = new node(val);
        if (this.size++ == 0)
            this.head = this.tail = n;
        else
            this.tail = this.tail.next = n;
        this.size++;

    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size)
            return;
        if (index == 0) {
            this.addAtHead(val);
            return;
        }
        if (index == size) {
            this.addAtTail(val);
            return;
        }
        node prev = this.getNode(index - 1);
        prev.next = new node(val, prev.next);
        this.size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size)
            return;
        node prev = this.getNode(index - 1);
        prev.next = prev.next.next;
        if (index == 0)
            this.head = prev.next;
        if (index == this.size - 1)
            this.tail = prev;
        this.size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */