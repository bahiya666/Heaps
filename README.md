Overview
This project implements a generic Heap data structure in Java, with two main variations: MaxHeap and MinHeap. A heap is a specialized tree-based data structure that satisfies the heap property. In a MaxHeap, the key of each parent node is greater than or equal to the keys of its children, while in a MinHeap, the key of each parent node is less than or equal to the keys of its children.

Features
MaxHeap: A heap where the largest element is at the root.
MinHeap: A heap where the smallest element is at the root.
Push: Inserts an element into the heap.
Pop: Removes and returns the root element (the largest for MaxHeap, smallest for MinHeap).
Peek: Returns the root element without removing it.

Classes and Methods
Heap<T extends Comparable<T>>
The Heap class is a generic class that provides common functionality for both MaxHeap and MinHeap. It provides methods for pushing, popping, and peeking elements while maintaining the heap property.

  Constructor:
  Heap(): Initializes an empty heap.
  Heap(T[] array): Initializes a heap using an existing array of elements.
  Methods:
  heapify(int index): Ensures that the heap property is maintained from the given index.
  push(T data): Inserts an element into the heap.
  pop(): Removes and returns the root element.
  peek(): Returns the root element without removing it.
  toString(): Returns a string representation of the heap.
  Helper Methods:
  getLeftChildIndex(int parentIndex): Returns the index of the left child of a given index.
  getRightChildIndex(int parentIndex): Returns the index of the right child of a given index.
  
MaxHeap<T extends Comparable<T>>
The MaxHeap class extends the Heap class and implements a heap where the largest element is always at the root.

  Constructor:
  MaxHeap(): Initializes an empty max-heap.
  MaxHeap(T[] array): Initializes a max-heap using an existing array.
  Overridden Method:
  compare(Comparable<T> child, Comparable<T> parent): Compares the elements to maintain the max-heap property (child > parent).
  
MinHeap<T extends Comparable<T>>
The MinHeap class extends the Heap class and implements a heap where the smallest element is always at the root.

Constructor:
  MinHeap(): Initializes an empty min-heap.
  MinHeap(T[] array): Initializes a min-heap using an existing array.
  Overridden Method:
  compare(Comparable<T> child, Comparable<T> parent): Compares the elements to maintain the min-heap property (child < parent).
  
Main
The Main class contains test code to demonstrate the functionality of MaxHeap and MinHeap. It performs various heap operations such as inserting, removing, and peeking elements.

Compilation
javac *.java
java Main
