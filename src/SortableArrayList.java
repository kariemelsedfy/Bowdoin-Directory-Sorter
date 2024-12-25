import java.util.Comparator;

/**
 * The SortableArrayList class is an extension of the SimpleArrayList
 * that adds sorting functionality for list elements using a custom comparator.
 *
 * This class allows sorting based on a specified ordering, implemented through
 * the Comparator interface.
 *
 * @param <T> the type of elements in this list
 */
public class SortableArrayList<T> extends SimpleArrayList<T> {
    /**
     * Constructor for SortableArrayList, calling the default constructor for
     * SimpleArrayList.
     */
    public SortableArrayList() {
        super();
    }

    /**
     * Constructor for SortableArrayList, calling the constructor for
     * SimpleArrayList.
     *
     * @param startingCapacity The desired starting list capacity
     */
    public SortableArrayList(int startingCapacity) {
        super(startingCapacity);
    }

    /**
     * Sorts the elements of this list according to the specified comparator.
     * Uses a selection sort algorithm to reorder elements in the list ascendingly.
     *
     * @param c the comparator used to determine the order of the elements
     */
    public void sort(Comparator<? super T> c) {
        for(int i = this.size(); i > 0; i--) {
            T tempLargestValue = (T) this.elementData[0];
            int tempLargestValueIndex = 0;
            for(int j = 0; j < i; j++) {
                if(c.compare((T) this.elementData[j], tempLargestValue) > 0) {
                    tempLargestValue = (T) this.elementData[j];
                    tempLargestValueIndex = j;
                }
            }
            T tempSwappingObject = (T) this.elementData[tempLargestValueIndex];
            this.elementData[tempLargestValueIndex] = this.elementData[i - 1];
            this.elementData[i - 1]=tempSwappingObject;
        }
    }
}
