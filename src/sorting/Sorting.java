package sorting;

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
                System.out.println(i);
                System.out.println(arr.get(i) + " < " + arr.get(i-1));
                throw new NotSortedException();
            }
        }
    }
    
    /**
     * Bubble sort without improvements
     * @param arr - ArrayList<> to sort
     * @return sorted ArrayList<>
     * @throws sorting.NotSortedException
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
    
    /**
     * Bubble sort improved by swap flag
     * @param arr ArrayList<> to be sorted
     * @return sorted ArrayList<>
     * @throws NotSortedException 
     */
    public List<Integer> BubbleSortV2(List<Integer> arr) throws NotSortedException {
        List<Integer> newArr = arr; 
        boolean swapped = false;
        
        for (int i = 0; i < newArr.size(); i++) {
            for (int j = 0; j < newArr.size(); j++) {
                if (newArr.get(i).compareTo(newArr.get(j)) < 0) {       
                    int tmp = newArr.get(i); 
                    newArr.set(i, newArr.get(j));
                    newArr.set(j, tmp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            } else {
                swapped = false;
            }
        }
        
        CheckSorting(newArr);
        return newArr;
    }
    
    /**
     * Bubble sort improved by swap flag and with steps reduction
     * @param arr ArrayList<> to be sorted
     * @return sorted ArrayList<>
     * @throws NotSortedException 
     */
    public List<Integer> BubbleSortV3(List<Integer> arr) throws NotSortedException {
        List<Integer> newArr = arr; 
        int n = newArr.size();
        int swap = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (newArr.get(i).compareTo(newArr.get(j)) < 0) {
                    int tmp = newArr.get(i); 
                    newArr.set(i, newArr.get(j));
                    newArr.set(j, tmp);
                    swap++;
                }
            }
            if (swap == 0) {
                break;
            }
            n--;
        }
        
        CheckSorting(newArr);
        return newArr;
    }
    
    /**
     * Selection Sort
     * @param arr ArrayList<> to be sorted
     * @return sorted ArrayList<>
     * @throws NotSortedException 
     */
    public List<Integer> SelectionSort(List<Integer> arr) throws NotSortedException {
        List<Integer> newArr = arr; 
        
        int k; // index of minimal element 
        int x; // value of minimal element
        
        for(int i = 0; i < newArr.size() - 1; i++) {
            k = i; 
            x = newArr.get(i);
            
            for (int j = i + 1; j < newArr.size(); j++) {
                if (newArr.get(j) < x) {
                    k = j;
                    x = newArr.get(j);
                }
            }
            newArr.set(k, newArr.get(i));
            newArr.set(i, x);
        }
        
        CheckSorting(newArr);
        return newArr;
    }
    
    /**
     * Insertion Sort
     * @param arr ArrayList<> to be sorted
     * @return sorted ArrayList<>
     * @throws NotSortedException 
     */
    public List<Integer> InsertionSort(List<Integer> arr) throws NotSortedException {
        List<Integer> newArr = arr; 
        int x, j;
        
        for (int i = 1; i < newArr.size(); i++) {
            x = newArr.get(i);
            j = i - 1;
            
            while((j >= 0) && (x < newArr.get(j))) {
                newArr.set(j+1, newArr.get(j));
                j = j - 1;
            }
            newArr.set(j + 1, x);
        }
        
        CheckSorting(newArr);
        return newArr;
    }
    
    /**
     * Shell Sort with h = array length / 2
     * @param arr ArrayList<> to be sorted
     * @return sorted ArrayList<>
     * @throws NotSortedException 
     */
    public List<Integer> ShellSort(List<Integer> arr) throws NotSortedException {
        List<Integer> newArr = arr; 
        int h = newArr.size() / 2;
        
        while (h > 0) {
            for (int i = h; i < newArr.size(); i++) {
                int x = newArr.get(i);
                int j = i;
                
                while ((j >= h) && (x < newArr.get(j-h))) {
                    newArr.set(i, newArr.get(j-h));
                    j -= h;
                }
                
                newArr.set(i, x);
            }
            
            h /= 2;
        }
        
        CheckSorting(newArr);
        return newArr;
    }
    
    /**
     * Shell Sort with h = 1
     * @param arr ArrayList<> to be sorted
     * @return sorted ArrayList<>
     * @throws NotSortedException 
     */
    public List<Integer> ShellSortV2(List<Integer> arr) throws NotSortedException {
        List<Integer> newArr = arr; 
        
        int h = 1;
        double tmp = newArr.size() / 9.0;
        
        while (h < tmp) {
            h = 3 * h + 1;
        }
        
        while (h > 0) {
            for (int i = h; i < newArr.size(); i++) {
                int x = newArr.get(i);
                int j = i;
                
                while ((j >= h) && (x < newArr.get(j-h))) {
                    newArr.set(i, newArr.get(j-h));
                    j -= h;
                }
                
                newArr.set(i, x);
            }
            
            h /= 3;
        }
        
        CheckSorting(newArr);
        return newArr;
    }
}
