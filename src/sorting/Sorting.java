package sorting;

import java.util.Collections;
import java.util.List;

/**
 * Singletonized class. Keeps basic sorting algorithms in one place
 * @author krystian
 */
public class Sorting {
    
    private static Sorting instance = null;
    
    protected Sorting() {}
    
    public static Sorting getInstance() {
        if (instance == null) {
            instance = new Sorting();
        }
        return instance;
    }
    
    public List<Integer> BubbleSort(List<Integer> arr) {
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
        
        return newArr; // @TODO
    }
}
