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
        System.out.println(arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < (arr.get(i-1))) {
                System.out.println(i);
                System.out.println(arr.get(i) + " > " + arr.get(i-1));
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
     * Shell Sort with increment = array length / 2
     * @param arr ArrayList<> to be sorted
     * @return sorted ArrayList<>
     * @throws NotSortedException 
     */
    public List<Integer> ShellSort(List<Integer> arr) throws NotSortedException {
        
        List<Integer> newArr = arr; 
        int increment = newArr.size() / 2;
                
        while (increment > 0) {
            for (int i = increment; i < newArr.size(); i++) {
                int j = i;
                int temp = newArr.get(i);
                
                while ((j >= increment) && (temp < newArr.get(j-increment))) {
                    newArr.set(j, newArr.get(j-increment));
                    j -= increment;
                }
                
                newArr.set(j, temp);
            }
            
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
        
        CheckSorting(newArr);
        return newArr;
    }
    
    /**
     * Shell Sort with increment = 1
     * @param arr ArrayList<> to be sorted
     * @return sorted ArrayList<>
     * @throws NotSortedException 
     */
    public List<Integer> ShellSortV2(List<Integer> arr) throws NotSortedException {
        List<Integer> newArr = arr; 
        
        int increment = 1;
        double tmp = newArr.size() / 9.0;
        
        while (increment < tmp) {
            increment = 3 * increment + 1;
        }
        
        while (increment > 0) {
            for (int i = increment; i < newArr.size(); i++) {
                int temp = newArr.get(i);
                int j = i;
                
                while ((j >= increment) && (temp < newArr.get(j-increment))) {
                    newArr.set(j, newArr.get(j - increment));
                    j -= increment;
                }
                
                newArr.set(j, temp);
            }
            
            increment /= 3;
        }
        
        CheckSorting(newArr);
        return newArr;
    }
    
    /**
     * Quick sort recurrent algorithm V1
     * @param arr ArrayList<> to be sorted
     * @param l left side of an array
     * @param r right side of an array
     * @return sorted ArrayList<>
     * @throws NotSortedException 
     */
    public List<Integer> QuickSort(List<Integer> arr, int l, int r) throws NotSortedException {
        List<Integer> newArr = arr; 
        
        System.out.println(newArr);
        
//        if (l < r) {
//            int t = newArr.get(l);  // pivot element
//            int s = l;  // dividing element
//            
//            for (int i = l + 1; i < r; i++) {
//                if (newArr.get(i).compareTo(t) > 0) {       
//                    s++; 
//                    
//                    int tmp = newArr.get(i); 
//                    newArr.set(i, newArr.get(s));
//                    newArr.set(s, tmp);
//                }
//            }            
////            System.out.println(newArr);
////            newArr = QuickSort(newArr, l, s);
////            newArr = QuickSort(newArr, s+1, r);
//        }
//        
//        CheckSorting(newArr);
        return newArr;
    }
    
    /**
     * Quick sort recurrent algorithm V2
     * @param arr ArrayList<> to be sorted
     * @param l left side of an array
     * @param r right side of an array
     * @return sorted ArrayList<>
     * @throws NotSortedException 
     */
    public List<Integer> QuickSortV2(List<Integer> arr, int l, int r) throws NotSortedException {
        List<Integer> newArr = arr; 
        
        int i = l;
        int j = r;
        int v = newArr.get((l + r) / 2); // pivot

            do {
                while (newArr.get(i) < v) i++;
                
                while (v<newArr.get(j)) j--;
                
                if (i<=j) {
                    int temp = newArr.get(i);
                    newArr.set(i, newArr.get(j));
                    newArr.set(j, temp);
                    i++;
                    j--;
                }
            }
            
            while (i<=j);
            if (l < j)
                QuickSortV2(newArr, l, j);
            if (i < r)
                QuickSortV2(newArr, i, r);
        
        CheckSorting(newArr);
        return newArr;
    }
}
