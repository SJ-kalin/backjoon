package back.step_00.datastructure;

import java.util.ArrayList;

public class MyList {
    public static void main(String[] args) {
        CustomList list = new CustomList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list.toString());
        System.out.println(list.remove(0));
        System.out.println(list.toString());

    }
}

class CustomList {

    private Object arr[];
    private int index = -1;

    public CustomList() {
        this.arr = new Object[10];
    }

    public CustomList(int count) {
        this.arr = new Object[count];
    }

    boolean add(int num) {
        if (index + 1 == this.arr.length) {
            Object temp[] = arr.clone();
            int size = this.arr.length;
            arr = new Object[size * 2];
            for (int i = 0; i < temp.length; i++) {
                arr[i] = temp[i];
            }
        }
        index++;
        this.arr[index] = num;
        return true;
    }

    boolean remove(int count) {
        if (count > this.index || this.index == 0) {
            return false;
        } else {
            for (int i = count; i < this.arr.length - 1; i++) {
                this.arr[i] = this.arr[i + 1];
            }
            this.arr[index] = null;
            index--;
            return true;
        }
    }

    boolean remove() {
        if (index == -1) {
            return false;
        } else {
            this.arr[index] = null;
            index--;
            return true;
        }
    }

    int size() {
        return this.index + 1;
    }

    Object get(int count) {
        if (index < count || index == -1) {
            return false;
        } else {
            return arr[count];
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                buffer.append(this.arr[i]);
            } else {
                buffer.append(this.arr[i] + ", ");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }
}