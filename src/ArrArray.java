import java.util.ArrayList;
import java.util.List;

class Element {
    Integer value;
    Integer cnt;
    Boolean lazyDeleted;

    public Element(Integer value) {
        this.value = value;
        this.cnt = 1;
        this.lazyDeleted = false;
    }

    public Integer getValue() {
        return this.value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer increment() {
        return ++this.cnt;
    }

    public Integer decrement() {
        return --this.cnt;
    }

    public Integer getCount() {
        return this.cnt;
    }

    public Boolean isLazyDeleted() {
        return this.lazyDeleted;
    }

    public void setLazyDeleted(Boolean lazyDeleted) {
        this.lazyDeleted = lazyDeleted;
    }

}

class ArrArrayCoord {
    private int arrIndex;
    private int elementIndex;

    public ArrArrayCoord(int arrIndex, int elementIndex) {
        this.arrIndex = arrIndex;
        this.elementIndex = elementIndex;
    }

    public int getArrIndex() {
        return this.arrIndex;
    }

    public int getElementIndex() {
        return this.elementIndex;
    }
}

// each array can either be completley full or empty
public class ArrArray {
    private List<Element[]> data = new ArrayList<Element[]>();
    // private long tableFullness = 0b0;

    public ArrArray() {
    }

    // insert that uses binary search to find the correct index to insert the value,
    // if it exists it increments the count and keeps in mind lazy deletion
    public void insert(Integer value) {
        // if the array is empty, add the value to the array
        if (data.isEmpty()) {
            Element[] arr = new Element[1];
            arr[0] = new Element(value);
            data.add(arr);
            return;
        }

        ArrArrayCoord coord = find(value, false, true);
        if (coord != null) {
            data.get(coord.getArrIndex())[coord.getElementIndex()].increment();
            data.get(coord.getArrIndex())[coord.getElementIndex()].setLazyDeleted(false);
            return;
        }

        // when the first empty array is found, add new value to it then move all arrays
        // below it into it and sort them, then clear the arrays below it
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i)[0] == null) {
                Element[] tmp = new Element[(int) Math.pow(2, i)];
                tmp[0] = new Element(value);

                if (i == 0) {
                    data.set(i, tmp);
                    return;
                }

                for (int j = 0; j < i; j++) {
                    mergeIntoArray(tmp, data.get(j));
                    for (int k = 0; k < data.get(j).length; k++)
                        data.get(j)[k] = null;
                }

                // sort the array
                sortArray(tmp);

                data.set(i, tmp);
                return;

            }
        }

        // if the array is completlety full, create a new array of size 2^i and move all
        // the values into the new array
        Element[] arr = new Element[data.get(data.size() - 1).length * 2];
        arr[0] = new Element(value);
        for (int i = 0; i < data.size(); i++) {
            mergeIntoArray(arr, data.get(i));
            for (int j = 0; j < data.get(i).length; j++)
                data.get(i)[j] = null;
        }

        sortArray(arr);
        data.add(arr);

    }

    private void mergeIntoArray(Element[] arr1, Element[] arr2) {
        int i = 0;
        while (arr1[i] != null) {
            i++;
        }
        for (int j = 0; j < arr2.length; j++) {
            arr1[i] = arr2[j];
            i++;
        }
    }

    private void sortArray(Element[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j].value > arr[j + 1].value) {
                    Element tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public Boolean isFull() {
        if (data.isEmpty()) {
            return false;
        }
        // if(data.get(data.size() - 1).length == data.get(data.size() - 1)[0]){
        // return true;
        // }

        for (int i = 0; i < data.get(data.size() - 1).length; i++) {
            if (data.get(data.size() - 1)[i] == null) {
                return false;
            }
        }
        return false;
    }

    public void printOut() {
        if (data.isEmpty()) {
            System.out.println("empty");
        }
        for (int i = 0; i < data.size(); i++) {
            System.out.printf("A_%d: ", i);

            if (data.get(i)[0] == null) {
                System.out.println("...");
                continue;
            }

            for (int j = 0; j < data.get(i).length; j++) {
                if (data.get(i)[j].isLazyDeleted()) {
                    System.out.print("x");
                } else
                    System.out.print(data.get(i)[j].getValue() + "/" + data.get(i)[j].getCount());
                if (j != data.get(i).length - 1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }

    // find an item and lazy delete it
    public void delete(Integer value) {
        ArrArrayCoord coord = find(value);
        if (coord == null) {
            return;
        }
        if (data.get(coord.getArrIndex())[coord.getElementIndex()].decrement() <= 0) {
            // data.get(coord.getArrIndex())[coord.getElementIndex()].setValue(null);
            data.get(coord.getArrIndex())[coord.getElementIndex()].setLazyDeleted(true);
        }
    }

    // find element using binary search and return
    public ArrArrayCoord find(Integer value) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i)[0] == null)
                continue;
            int low = 0;
            int high = data.get(i).length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (data.get(i)[mid].getValue() == value) {
                    if (data.get(i)[mid].isLazyDeleted()) {
                        System.out.println("false");
                        return null;
                    }
                    System.out.println("true");

                    return new ArrArrayCoord(i, mid);
                } else if (data.get(i)[mid].getValue() > value) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        System.out.println("false");
        return null;
    }

    public ArrArrayCoord find(Integer value, boolean echo, boolean includeLazyDeleted) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i)[0] == null)
                continue;
            int low = 0;
            int high = data.get(i).length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (data.get(i)[mid].getValue() == value) {
                    if (data.get(i)[mid].isLazyDeleted() && !includeLazyDeleted) {
                        if (echo)
                        System.out.println("false");
                        return null;
                    }
                    if (echo)
                        System.out.println("true");

                    return new ArrArrayCoord(i, mid);
                } else if (data.get(i)[mid].getValue() > value) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        if (echo)
            System.out.println("false");
        return null;
    }
}
