package com.lab111.labwork5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by verrden on 05.05.16.
 */
public class CustomList implements Iterable<Integer> {
    private int count;
    private int index;
    private Integer listStruct[];
    private Integer[] indexies;
    private static int current = 0;

    public CustomList() {
        listStruct = new Integer[15];
        count = 0;
    }


    public CustomList(Integer o) {
        this();
        add(o);
    }

    public CustomList(ArrayList<Integer> list) {
        this();
        if (list.size() > 15) {
            listStruct = (Integer[]) new Object[(int) (list.size() * 1.3)];
        }
        for (Integer T : list) {
            add(T);
        }
    }


    public boolean add(Integer e) {
        resize();
        listStruct[count] = e;
        count++;
        indexies = new Integer[count];
        return true;
    }


    public void add(int index, Integer element) {
        try {
            shiftRight(index);
            listStruct[index] = element;

        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        }
    }


    public boolean addAll(Collection<? extends Integer> c) {
        for (Integer T : c) {
            add(T);
        }
        return true;
    }


    public boolean addAll(int index, Collection<? extends Integer> c) {
        if (index == count) {
            return addAll(c);
        }
        Iterator<? extends Integer> it = c.iterator();
        while (it.hasNext()) {
            add(index, it.next());
            index++;
        }
        return true;
    }


    public void clear() {
        listStruct = (Integer[]) new Object[15];
        count = 0;
    }


    public boolean contains(Object o) {
        for (int i = 0; i < count; i++) {
            if (listStruct[i].equals(o)) {
                return true;
            }
        }
        return false;
    }


    public boolean containsAll(Collection<?> c) {
        for (Object object : c) {
            if (!(contains(object))) {
                return false;
            }
        }
        return true;
    }


    public Integer get(int index) {
        Integer output;
        try {
            output = listStruct[index];
            return output;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }


    public int indexOf(Object o) {
        for (int i = 0; i < count; i++) {
            if (listStruct[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }


    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    public boolean isAdd(int index) {
        int i = 0;
        while (indexies[i]!=null) {
            if (indexies[i] == index) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void addIndexes() {
        int maxValue = Integer.MAX_VALUE;
        int minIndex = -1;
        int i = 0;
        while (listStruct[i] != null) {
            if (listStruct[i] < maxValue) {
                if (isAdd(i)) {
                    i++;
                    continue;
                }
                maxValue = listStruct[i];
                minIndex = i;

            }
            i++;
        }
        if (minIndex == -1) {
            return;
        } else {
            indexies[current] = minIndex;
            current++;
        }
    }

    public Iterator<Integer> iterator() {
        index = 0;
        return new MyIterator() {
            @Override
            public boolean hasNext() {
                if (index < listStruct.length && listStruct[index] != null) {
                    return true;
                }
                return false;
            }

            @Override
            public Integer next() {
                if (this.hasNext()) {
                    return listStruct[index++];
                }
                return null;
            }
        };
    }

    public Integer[] copyMass(Integer[] mass) {
        int count = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] != null) {
                count++;
            }
        }
        Integer[] newMass = new Integer[count];
        for (int i = 0; i < count; i++) {
            newMass[i] = mass[i];
        }
        return newMass;
    }

    public Iterator<Integer> sortedIterator() {
        index = 0;
        return new MyIterator() {
            @Override
            public boolean hasNext() {
                if (index < listStruct.length && listStruct[index] != null) {
                    return true;
                }
                return false;
            }

            @Override
            public Integer next() {
                if (this.hasNext()) {
                    addIndexes();
                    int i = indexies[index++];
                    return listStruct[i];
                }
                return null;
            }
        };
    }


    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (listStruct[i].equals(o)) {
                index = i;
            }
        }
        return index;
    }


    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        }
        int index = indexOf(o);
        try {
            shiftLeft(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public Integer remove(int index) {
        Integer current = null;
        try {
            current = listStruct[index];
            shiftLeft(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return current;
    }


    public boolean removeAll(Collection<?> c) {
        boolean removed = false;
        Iterator<?> it = c.iterator();
        while (it.hasNext()) {
            if (remove(it.next())) {
                removed = true;
            }
        }
        return removed;
    }


    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        for (int i = 0; i < count; ) {
            if (!(c.contains(listStruct[i]))) {
                try {
                    shiftLeft(i);
                } catch (ArrayIndexOutOfBoundsException e) {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                changed = true;
            } else {
                i++;
            }
        }
        return changed;
    }


    public Integer set(int index, Integer element) {
        Integer current;
        try {
            current = listStruct[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
        listStruct[index] = element;
        return current;
    }


    public int size() {
        return count;
    }


    public CustomList subList(int fromIndex, int toIndex) {
        CustomList output = new CustomList();
        for (int i = fromIndex; i <= toIndex; i++) {
            try {
                output.add(listStruct[i]);
            } catch (ArrayIndexOutOfBoundsException e) {
                return null;
            }
        }
        return output;
    }


    public Object[] toArray() {
        Object array[] = new Object[count];
        for (int i = 0; i < count; i++) {
            array[i] = (Object) listStruct[i];
        }
        return array;
    }


    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean equals(Object arg0) {
        if (arg0 instanceof CustomList) {
            CustomList chech = (CustomList) arg0;
            if (chech.size() == this.size()) {
                for (int i = 0; i < this.size(); i++) {
                    if (!(this.get(i).equals(chech.get(i)))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }


    private void resize() {
        if (size() == listStruct.length) {
            double length = (double) listStruct.length;
            length *= 1.3;
            length++;
            Integer currentStruct[] = (Integer[]) new Object[(int) length];
            System.arraycopy(listStruct, 0, currentStruct, 0, count);
            listStruct = currentStruct;
        }
    }


    public void resize(int newSize) throws Exception {
        if (newSize < count) {
            throw new Exception(
                    "Resize fail. List contains more elements then new size");
        }
        Integer currentStruct[] = (Integer[]) new Object[newSize];
        System.arraycopy(listStruct, 0, currentStruct, 0, count);
        listStruct = currentStruct;
    }

    public void shiftLeft(int index) throws Exception,
            Exception {
        if (index == -1) {
            throw new Exception("Failed shift to index = -1");
        }
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.arraycopy(listStruct, index + 1, listStruct, index, size()
                - index - 1);
        listStruct[--count] = null;
    }

    private void shiftRight(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException();
        }
        resize();
        System.arraycopy(listStruct, index, listStruct, index + 1, count
                - index);
        listStruct[index] = null;
        count++;
    }
}
