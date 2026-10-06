import java.util.*;

class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {

        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        void add(Node node) {

            Node previous = tail.prev;

            previous.next = node;
            node.prev = previous;

            node.next = tail;
            tail.prev = node;

            size++;
        }

        void remove(Node node) {

            Node previous = node.prev;
            Node next = node.next;

            previous.next = next;
            next.prev = previous;

            size--;
        }

        Node removeFirst() {

            if (size == 0) {
                return null;
            }

            Node node = head.next;

            remove(node);

            return node;
        }
    }

    int capacity;
    int minFreq;

    HashMap<Integer, Node> map;

    HashMap<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;

        minFreq = 0;

        map = new HashMap<>();

        freqMap = new HashMap<>();
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            increaseFrequency(node);

            return;
        }

        // Cache is full
        if (map.size() == capacity) {

            DoublyLinkedList list = freqMap.get(minFreq);

            Node lfuNode = list.removeFirst();

            map.remove(lfuNode.key);
        }

        Node newNode = new Node(key, value);

        map.put(key, newNode);

        if (!freqMap.containsKey(1)) {
            freqMap.put(1, new DoublyLinkedList());
        }

        freqMap.get(1).add(newNode);

        minFreq = 1;
    }

    private void increaseFrequency(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        // If this was the minimum frequency
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        int newFreq = node.freq;

        if (!freqMap.containsKey(newFreq)) {
            freqMap.put(newFreq, new DoublyLinkedList());
        }

        freqMap.get(newFreq).add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */