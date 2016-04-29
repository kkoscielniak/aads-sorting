package sorting;

import java.util.Collections;
import java.util.List;

/**
 * Singleton class. Keeps basic sorting algorithms in one place
 * @author krystian
 */
public class Sorting {
    
    private static Sorting instance = null;
    
    protected Sorting() {}
    
    /**
     * Allows to use Singleton design (anti?) pattern
     * @return the singleton instance of this class
     */
    public static Sorting getInstance() {
        if (instance == null) {
            instance = new Sorting();
        }
        return instance;
    }
 
    /**
     * Checks if array is sorted properly
     * @param arr - array to be tested
     * @throws NotSortedException 
     */
    private void CheckSorting(List<Integer> arr) throws NotSortedException {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < (arr.get(i - 1))) {
                throw new NotSortedException();
            }
        }
    }
    
    /**
     * Bubble sort without improvements
     * @param arr - ArrayList<> to sort
     * @return sorted ArrayList<>
     */
    public List<Integer> BubbleSort(List<Integer> arr) throws NotSortedException {
        List<Integer> newArr = arr; 
        
        for (int i = 0; i < newArr.size(); i++) {
            for (int j = 0; j < newArr.size(); j++) {
                if (newArr.get(i).compareTo(newArr.get(j)) < 0) {
                    
                    int tmp = newArr.get(i); 
                    newArr.set(i, newArr.get(j));
                    newArr.set(j, tmp);
                    
                }
            }
        }
        
        CheckSorting(newArr);
        return newArr;
    }
}
