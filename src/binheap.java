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

        //if the heap contains the key, return
        for(int i = 0; i < heap.length; i++){
            if(heap[i] == key){
                return;
            }
        }

        Integer[] newHeap = new Integer[heap.length + 1];
        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }
        newHeap[heap.length] = key;
        heap = newHeap;
        
        //fix the heap
        heapifyUp(heap.length - 1);
    }

    void heapifyUp(int index) {
        if (index == 0) {
            return;
        }
        int parent = parent(index);
        comparisons++;
        if (heap[parent] > heap[index]) {
            swap(parent, index);
            heapifyUp(parent);
        }
    }


    private void minHeapify(int key){
        int left = left(key);
        int right = left(key) + 1;
        int smallest = key;

        if(heap.length <= 1){
            return;
        }

        // if there is only one child make only one comparison
        if(left < heap.length && right >= heap.length){
            comparisons++;
            smallest = left;
            minHeapify(smallest);
            return;
        }
        
        if(left < heap.length && heap[left] < heap[key]){
            comparisons++;
            smallest = left;
        }

        if(right < heap.length && heap[right] < heap[smallest]){
            comparisons++;
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
