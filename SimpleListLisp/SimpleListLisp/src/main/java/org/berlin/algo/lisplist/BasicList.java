package org.berlin.algo.lisplist;

/**
 * Build a basic list, linked list approach.
 */
public class BasicList {

    public static class Node {

        /**
         * The first element of the pair.
         */
        public Object data;

        /**
         * The other element of the pair.
         */
        public Node next;

        /**
         * Build a pair from two components.
         */
        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
        public Node(Object data) {
            this(data, null);
        }

        /**
         * Return a String representation of the pair.
         */
        public String toString() {
            return "" + data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
        public String stringifyNode(StringBuffer buf) {
            buf.append('(');
            buf.append(data);
            Object tail = this.getNext();
            while (tail instanceof Node) {
                buf.append(' ');
                buf.append(((Node) tail).getData());
                tail = ((Node) tail).getNext();
            }
            if (tail != null) {
                buf.append(" . ");
                ((Node) tail).stringifyNode(buf);
            }
            buf.append(')');
            return buf.toString();
        }
    }

    public static class LinkedList {
        /**
         * Head element in linked list.
         */
        public Node head;

        private LinkedList() {
        }

        public LinkedList(Node head) {
            this.head = head;
        }

        public LinkedList(String data) {
            this.head = new Node(data, null);
        }

        /**
         * Add a new node and replace the "root" node with the new one.
         * 
         * @param node
         * @return
         */
        public LinkedList insertHead(final Node node) {
            node.setNext(head);
            head = node;
            return this;
        }

        public void insertTail(final Node node) {
            if (head == null) {
                head = node;
            } else {
                Node p, q;
                // Traverse to the end of the list
                for (p = head; (q = p.getNext()) != null; p = q) {
                    ;
                }
                p.setNext(node);
            }
        }
        
        public void insertTail(final String nodeData) {            
            this.insertTail(new Node(nodeData, null));
        }

        public String traverse() {
            // Append the contents to a string
            final StringBuffer buf = new StringBuffer();
            buf.append("(");
            buf.append(this.getHead());
            for (Node node = this.getHead().getNext(); node != null; node = node.getNext()) {
                buf.append(' ');
                buf.append(node.getData());
            }
            buf.append(")");
            return buf.toString();
        }
        
        
        public String toString() {
            return this.traverse();
        }

        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }

    }

    public static void main(final String[] args) {
        System.out.println("Running");
        final LinkedList list = new LinkedList("+");
        list.insertTail("1");
        list.insertTail("2");
        System.out.println(list);
        
        System.out.println();
        System.out.println("Done");
    }
}
