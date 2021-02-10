class LRUCache{
    Map<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node tail = null;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null) {
            node.val = value;
            moveToHead(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            insertIntoHead(node);
        }
        if(map.size()>capacity) {
            map.remove(tail.key);
            removeTail();
        }
    }

    public void moveToHead(Node node) {
        if(node == head) return;
        node.prev.next = node.next;
        if(node != tail) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        
        node.next = head;
        head.prev = node;
        head = node;
    }

    public void insertIntoHead(Node node) {
        if(head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void removeTail() {
        if(head == tail) {
            head = null;
            tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
        }
    }
}
class Node {
    Node prev;
    Node next;
    int key;
    int val;
    Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */