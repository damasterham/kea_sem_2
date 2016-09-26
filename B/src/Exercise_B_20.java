// Class LinkedIntList can be used to store a list of integers.

import java.util.NoSuchElementException;

public class Exercise_B_20
{
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public Exercise_B_20() {
        front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current !=  null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    // Exercise_B_19 Ch16Ex1
    public void set(int index, int value)
    {
        ListNode current;
        current = nodeAt(index);
        current.data = value;
    }


    // Exercise_B_20 Ch16Ex2
    public int max()
    {
        if (size() == 0)
        {
            throw new NoSuchElementException();
        }
        int max = 0;
        ListNode current = front;
        for (int i = 0; i < size(); i++) {
            if (current.data > max)
            {
                max = current.data;
            }
            current = current.next;
        }

        return max;
    }


    public static void main(String[] args)
    {
        Exercise_B_20 list;
        list = new Exercise_B_20();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(4);

        System.out.println(list.toString());
        System.out.println(list.max());

        try
        {
            Exercise_B_20 list2 = new Exercise_B_20();
            list2.max();
        }
        catch (NoSuchElementException e)
        {
            System.out.println(e);
        }

    }
}
