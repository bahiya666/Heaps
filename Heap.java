public abstract class Heap<T extends Comparable<T>> {

    public Comparable<T>[] data;
    public int size;

    public Heap() {
        this.data = (Comparable<T>[]) new Comparable[2];
        size = 0;
    }

    // Constructor with array parameter
    public Heap(T[] array) {
        this.data = (Comparable<T>[]) new Comparable[array.length]; // Initialize data array with length of input array
        size = array.length; // Set size to the length of input array
        System.arraycopy(array, 0, data, 0, array.length); // Copy elements from input array to data array

        // Apply Floyd's Algorithm to build a valid heap
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }
    }

    // Heapify method to maintain heap property
    protected void heapify(int index) {
        int leftChildIndex = getLeftChildIndex(index);
        int rightChildIndex = getRightChildIndex(index);
        int largestIndex = index; // Initialize largest index as the current node index

        // Check if left child exists and is larger than the current node
        if (leftChildIndex < size && compare(data[leftChildIndex], data[largestIndex])) {
            largestIndex = leftChildIndex;
        }

        // Check if right child exists and is larger than the current node or left child
        if (rightChildIndex < size && compare(data[rightChildIndex], data[largestIndex])) {
            largestIndex = rightChildIndex;
        }

        // If the largest node is not the current node, swap and heapify recursively
        if (largestIndex != index) {
            swap(index, largestIndex);
            heapify(largestIndex);
        }
    }

    // Helper method to swap elements in the data array
    private void swap(int i, int j) {
        Comparable<T> temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    protected abstract boolean compare(Comparable<T> child, Comparable<T> parent);

    // Push method to add data to the heap
    public void push(T data) {
        // Check if data array is full
        if (size == this.data.length) {
            // Double the size of the data array and copy its contents to the new array
            Comparable<T>[] newData = (Comparable<T>[]) new Comparable[this.data.length * 2];
            System.arraycopy(this.data, 0, newData, 0, size);
            this.data = newData;
        }
        
        // Add the new data to the end of the data array
        this.data[size] = data;
        size++;

        // Perform swaps to maintain heap property
        int currentIndex = size - 1;
        int parentIndex = (currentIndex - 1) / 2;
        while (currentIndex > 0 && compare(this.data[currentIndex], this.data[parentIndex])) {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / 2;
        }
    }

    public Comparable<T> pop() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        // Store the root element to be returned
        Comparable<T> root = data[0];

        // Swap the root element with the last element in the heap
        swap(0, size - 1);
        size--;

        // Heapify the root element to restore the heap property
        heapify(0);

        return root;
    }

    public Comparable<T> peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        // Return the root element
        return data[0];
    }

    /*
     * 
     * Functions used for the toString
     * Do not change them but feel free to use them
     * 
     */

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        buildString(0, "", true, sb); // Start from the root
        return sb.toString();
    }

    private void buildString(int index, String prefix, boolean isTail, StringBuilder sb) {
        if (index < size) {
            String linePrefix = isTail ? "└── " : "┌── ";
            if (getRightChildIndex(index) < size) { // Check if there is a right child
                buildString(getRightChildIndex(index), prefix + (isTail ? "|   " : "    "), false, sb);
            }
            sb.append(prefix).append(linePrefix).append(data[index]).append("\n");
            if (getLeftChildIndex(index) < size) { // Check if there is a left child
                buildString(getLeftChildIndex(index), prefix + (isTail ? "    " : "│   "), true, sb);
            }
        }
    }

}
