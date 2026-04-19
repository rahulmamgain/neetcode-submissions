class LRUCache {
    
    private int capacity = 0;
    private Map<Integer, Node> kv = new HashMap();
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.prev = null;
        tail.next = null;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = kv.get(key);
        if(null == node) {
            return -1;
        }
        this.remove(node);
        this.addToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(kv.containsKey(key)) {
            this.remove(kv.get(key));
            kv.remove(key);
        }
        if(kv.size() == capacity) {
            Node toBeRemoved = tail.prev;
            remove(toBeRemoved);
            kv.remove(toBeRemoved.key);
        }
        Node newNode = new Node(key, value);
        this.addToFront(newNode);
        kv.put(key, newNode);
    }

    private void addToFront(Node node) {
        Node tmp = head.next;
        head.next = node;
        node.next = tmp;
        tmp.prev = node;
        node.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node() {}
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
