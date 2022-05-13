import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    private void resizeArray(){
        T[] newBackingArray = (T[]) new Comparable[2 * (size+1)];
        for(int i = 1; i < backingArray.length; i++){
            newBackingArray[i] = backingArray[i];
        }
        backingArray = newBackingArray;
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null){
            throw new IllegalArgumentException();
        }
        if(size == backingArray.length-1){
            resizeArray();
        }
        backingArray[size+1] = data;
        int curr_idx = size+1;
        while(curr_idx > 1){
            int parent_idx = curr_idx/2;
            if(backingArray[parent_idx].compareTo(backingArray[curr_idx]) < 0){
                break;
            }
            T tmp = backingArray[parent_idx];
            backingArray[parent_idx] = backingArray[curr_idx];
            backingArray[curr_idx] = tmp;
            curr_idx = parent_idx;
        }
        size++;
    }         

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(size == 0){
            throw new NoSuchElementException();
        }
        T to_return = backingArray[1];
        backingArray[1] = backingArray[size]; 
        backingArray[size] = null;
        size--;
        int curr_idx = 1;
        while(true){
            // has 2 children
            if(2*curr_idx + 1 <= size){
                int left_idx = 2*curr_idx;
                int right_idx = 2*curr_idx + 1;
                // left child is lower than right child
                if(backingArray[left_idx].compareTo(backingArray[right_idx]) < 0){
                    // left child is lower than curr
                    if(backingArray[left_idx].compareTo(backingArray[curr_idx]) < 0){
                        T tmp = backingArray[left_idx];
                        backingArray[left_idx] = backingArray[curr_idx];
                        backingArray[curr_idx] = tmp;
                        curr_idx = left_idx;
                    }else{
                        break;
                    }
                // right child is lower than left child
                }else{
                    // right child is lower than curr
                    if(backingArray[right_idx].compareTo(backingArray[curr_idx]) < 0){
                        T tmp = backingArray[right_idx];
                        backingArray[right_idx] = backingArray[curr_idx];
                        backingArray[curr_idx] = tmp;
                        curr_idx = right_idx;
                    }else{
                        break;
                    }
                }
            // just has left child
            }else if(2*curr_idx <= size){
                int left_idx = 2*curr_idx;
                if(backingArray[left_idx].compareTo(backingArray[curr_idx]) < 0){
                    T tmp = backingArray[left_idx];
                    backingArray[left_idx] = backingArray[curr_idx];
                    backingArray[curr_idx] = tmp;
                    curr_idx = left_idx;
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        return to_return;

    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}