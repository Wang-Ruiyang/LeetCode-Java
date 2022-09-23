/*
 * @lc app=leetcode.cn id=707 lang=java
 *
 * [707] 设计链表
 */

// @lc code=start
class MyLinkedList {

    static class Node {
        int val;
        Node pre;
        Node next;
        public Node() {
        }
        public Node(int val) {
            this.val = val;
        }
    }

    Node head;
    int size=0;

    public MyLinkedList() {
        head = new Node();
        head.next = head;
        head.pre = head;
    }

    //head->0->1->2      index=2  i=0,0, i=1,1, i=2,2
    public int get(int index) {
        int i = 0;
        Node node = head;
        if (index>=size || index<0) {
            return -1;
        }
        while (i<=index) {
            node = node.next;
            i++;
        }
        return node.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node();
        node.val = val;
        head.next.pre = node;
        node.next =  head.next;
        head.next = node;
        node.pre = head;
        size++;
    }
    
    public void addAtTail(int val) {
        Node node = new Node();
        node.val = val;
        head.pre.next = node;
        node.pre = head.pre;
        head.pre = node;
        node.next = head;
        size++;
    }

    //head->1->2->3->head
    public void addAtIndex(int index, int val) {
        Node node = new Node();
        node.val = val;
        if (index < 0) {
            this.addAtHead(val);
        }
        else {
            if (index==size) {
                this.addAtTail(val);
            }
            else if (index<size) {
                int i = 0;
                Node lo = head;
                Node ad = new Node();
                ad.val = val;
                while (i<index) {
                    lo = lo.next;
                    i++;
                }
                lo.next.pre = ad;
                ad.next = lo.next;
                lo.next = ad;
                ad.pre = lo;
                size++;
            }
        }
    }
    
    public void deleteAtIndex(int index) {
        if (index<size && index>=0) {
            int i = 0;
            Node node = head;
            while (i<=index) {
                node = node.next;
                i++;
            }
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

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
// @lc code=end

