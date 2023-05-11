public class binheap {
    Integer[] heap;
    int comparisons = 0;

    binheap() {
        heap = new Integer[0];
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return 2 * index + 2;
    }

    void insert(int key) {
        Integer[] newHeap = new Integer[heap.length + 1];
        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }
        newHeap[heap.length] = key;
        heap = newHeap;
        heapifyUp(heap.length - 1);
    }

    void heapifyUp(int index) {
        int parent = parent(index);
        comparisons++;
        if (heap[parent] > heap[index]) {
            swap(parent, index);
            heapifyUp(parent);
        }
    }


    void delete(int key) {
        Integer[] newHeap = new Integer[heap.length - 1];
        int index = -1;
        for (int i = 0; i < heap.length; i++) {
            if (heap[i] == key) {
                comparisons++;
                index = i;
                break;
            }
        }
        if (index == -1) {
            return;
        }
        for (int i = 0; i < index; i++) {
            newHeap[i] = heap[i];
        }
        for (int i = index; i < heap.length - 1; i++) {
            newHeap[i] = heap[i + 1];
        }
        heap = newHeap;
        heapifyDown(index);
    }

    void heapifyDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;

        comparisons++;
        if (left < heap.length && heap[left] < heap[index]) {
            smallest = left;
        }

        comparisons++;
        if (right < heap.length && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;
            heapifyDown(smallest);
        }
    }

    // void deleteMin() {
    //     if(heap.length > 0){
    //         int tmp = heap[0];
    //         delete(heap[0]);
    //         System.out.printf("true: %d\n", tmp);
    //         return;
    //     }
    //     System.out.println("false");
    // }


    private void minHeapify(int key){
        int left = left(key);
        int right = left(key) + 1;
        int smallest = key;

        comparisons++;
        if(left < heap.length && heap[left] < heap[key]){
            smallest = left;
        }

        comparisons++;
        if(right < heap.length && heap[right] < heap[smallest]){
            smallest = right;
        }

        if(smallest != key){
            swap(key, smallest);
            minHeapify(smallest);
        }
    }

    void deleteMin() {
        if (heap.length <= 0) {
            System.out.println("false");
            return;
        }
 
        if (heap.length == 1) {
            System.out.printf("true: %d\n", heap[0]);
            heap = new Integer[0];
            return;
        }
        
        int root = heap[0];

        heap[0] = heap[heap.length - 1];
        minHeapify(0);

        //shrink the array by 1
        Integer[] newHeap = new Integer[heap.length - 1];
        for (int i = 0; i < heap.length - 1; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;

        System.out.printf("true: %d\n", root);
    }

    void printElements() {
        if (heap.length == 0) {
            System.out.println("empty");
            return;
        }
        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i]);
            if (i < heap.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    void printMin(){
        System.out.printf("MIN: %s\n", heap.length>0 && heap[0]!=null ? heap[0].toString() : "none");
    }

    void printComparisons() {
        System.out.println("COMPARISONS: " + comparisons);
    }
}
