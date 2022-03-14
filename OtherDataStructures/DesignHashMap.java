class MyHashMap {
    // Use a linkedList structure to handle collision    
    class Node {
        // put key as final to ensure that it could not be changed
        final int key;
        int val;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        }        
    }
    // according to the constraints, there are maximum 10,000 calls, so the array size is made to 10001 to ensure no outbounds
    final int SIZE = 10001;
    Node[] array;
    public MyHashMap() {
        array = new Node[SIZE];
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        Node head = array[index];
        Node node = head;
        // if node is not null, meaning it has already appearred at least once in previous calls
        // there is also a possiblility that there is a collison (i.e. same index but different key)
        // the code need to loop to the end of that index 'branch', and add the value to the end   
        while(node != null) {
            if (node.key == key) {
                node.val = value;
                return;
            }
            node = node.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = head;
        array[index] = newNode;
    }
    
    public int get(int key) {
        int index = hash(key);
        Node node = array[index];
        // Similarly, in consideration of collision, we need to loop through the pairs with same index
        while (node != null) {
            if (node.key == key) return node.val;
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index= hash(key);
        Node node = array[index];
        while (node != null) {
            if (node.key == key) {
                node.val = -1;
                return;
            }
            node = node.next;
        }
    }
    
    private int hash(int key) {
        return Integer.hashCode(key) % SIZE;
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 
     int[] data;
    public MyHashMap() {
        data = new int[1000001];
        Arrays.fill(data, -1);
    }
    
    public void put(int key, int value) {
        data[key] = value;
    }
    
    public int get(int key) {
        return data[key];
    }
    
    public void remove(int key) {
        data[key] = -1;
    }
    
 */