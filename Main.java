public class Main {
    public static void main(String[] args) throws Exception {
        // Test MinHeap
        System.out.println("Testing MinHeap:");

        // Test default constructor
        MinHeap<Integer> minHeap1 = new MinHeap<>();
        System.out.println("Default MinHeap: " + minHeap1.toString());

        // Test constructor with array parameter
        Integer[] array = {3, 2, 8, 5, 1};
        MinHeap<Integer> minHeap2 = new MinHeap<>(array);
        System.out.println("MinHeap from array: " + minHeap2.toString());

        // Test push method
        minHeap2.push(4);
        System.out.println("MinHeap after push(4): " + minHeap2.toString());

        // Test pop method
        System.out.println("Pop from MinHeap: " + minHeap2.pop());
        System.out.println("MinHeap after pop: " + minHeap2.toString());

        // Test peek method
        System.out.println("Peek from MinHeap: " + minHeap2.peek());
        System.out.println();

        // Test MaxHeap
        System.out.println("Testing MaxHeap:");

        // Test default constructor
        MaxHeap<Integer> maxHeap1 = new MaxHeap<>();
        System.out.println("Default MaxHeap: " + maxHeap1.toString());

        // Test constructor with array parameter
        MaxHeap<Integer> maxHeap2 = new MaxHeap<>(array);
        System.out.println("MaxHeap from array: " + maxHeap2.toString());

        // Test push method
        maxHeap2.push(9);
        System.out.println("MaxHeap after push(9): " + maxHeap2.toString());

        // Test pop method
        System.out.println("Pop from MaxHeap: " + maxHeap2.pop());
        System.out.println("MaxHeap after pop: " + maxHeap2.toString());

        // Test peek method
        System.out.println("Peek from MaxHeap: " + maxHeap2.peek());
    }
}
