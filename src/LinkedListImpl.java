import java.util.*;

public class LinkedListImpl<E> implements List {

    private Node<E> firstNode = null;
    private Node<E> currentNode;
    private int size = 0;


    @Override
    public boolean add(Object o) {
        if (currentNode == null){
            currentNode = new Node<>(null, (E) o, null);
            firstNode = currentNode;
        }else{
            currentNode.next = new Node<>(currentNode, (E) o, null);
            currentNode = currentNode.next;
        }
        size++;
        return true;
    }

    @Override
    public void clear() {
        currentNode = null;
        firstNode = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        if (index < size) {
            Node searchResult = firstNode;
            for (int i = 0; i < index; i++) {
                searchResult = currentNode.next;
            }
            return searchResult.item;
        }else {
            return new IndexOutOfBoundsException("Item with index " + index + " " + "doesn`t exist!" );
        }
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }


    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        Node temp = firstNode;
        Node temp2;

        if (index == 0) {
            temp.next.prev = null;
            firstNode = temp.next;
            size--;
        } else if (index >= size)
            throw new IndexOutOfBoundsException("Item with index " + index + " " + "doesn`t exist");
        else if (index < size - 1) {
            for (int i = 0; i < index; i++)
                temp = firstNode.next;

            temp2 = temp.next;
            temp.next.prev = temp.prev;
            temp.prev.next = temp2;

            size--;
        } else {
            for (int i = 0; i < index - 1; i++)
                temp = firstNode.next;
            temp.next = null;

            size--;
        }

        return temp;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E item, Node<E> next ) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}