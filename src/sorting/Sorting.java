package sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class. Keeps basic sorting algorithms in one place
 * @author krystian
 * @param <T> Template
 */
public class Sorting<T> {

    public static final boolean DEBUG = false;
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
    private void CheckSorting(List<T> arr) throws NotSortedException, DifferentTypesException {

        for (int i = 1; i < arr.size(); i++) {
            if (Compare(arr.get(i), (arr.get(i-1))) < 0)   {
                System.out.println("Index of element which is not in it's order: " + (i+1));
                System.out.println(arr.get(i) + " >/= " + arr.get(i-1));
                System.out.print(arr);
                throw new NotSortedException();
            }
        }
    }

    private int Compare(T a, T b) throws DifferentTypesException {

        if (a.getClass() == String.class) {
            return a.toString().compareToIgnoreCase(b.toString());
        }
        else if (a.getClass() == Integer.class) {
            Integer first = (Integer)a;
            Integer second = (Integer)b;
            return (first.compareTo(second));
        } else {
            throw new DifferentTypesException();
        }
    }

    /**
    * Join the less array, pivot integer, and greater array to single array.
    * @param less integer ArrayList with values less than pivot.
    * @param pivot the pivot integer.
    * @param greater integer ArrayList with values greater than pivot.
    * @return the integer ArrayList after join.
    */
    private List<T> Concatenate(List<T> less, T pivot, List<T> greater){

        List<T> list = new ArrayList<>();

        less.stream().forEach((les) -> {
            list.add(les);
        });

        list.add(pivot);

        greater.stream().forEach((greater1) -> {
            list.add(greater1);
        });

        return list;
    }

    /**
     * Calculates median of 3 of the array
     * @param array array in which we find the median of 3
     * @param left top-left element
     * @param right top-right element
     * @return medianOf3
     * @throws DifferentTypesException
     */
    public int medianOf3(List<T> array, int left, int right) throws DifferentTypesException {
        
        int center = (int)Math.floor((left + right) / 2);
        
        if (DEBUG) {
            System.out.println("Top left element: " + array.get(left));
            System.out.println("Center element: " + array.get(center));
            System.out.println("Top right element: " + array.get(right));

        }
        
        if (Compare(array.get(left),array.get(center)) > 0)
            array = swap(array, left, center);

        if (Compare(array.get(left),array.get(right)) > 0)
            array = swap(array, left, right);

        if (Compare(array.get(center),array.get(right)) > 0)
            array = swap(array, center, right);

        array = swap(array, center, right - 1);
        return array.indexOf(array.get(right - 1));
    }

    
    /**
     * Swaps elements in array
     * @param array array in which we swap elements
     * @param dex1 index of first element
     * @param dex2 index of second element
     * @return array in which elements are swapped
     */
    private List<T> swap(List<T> array, int dex1, int dex2) {
        T temp = array.get(dex1);
        array.set(dex1, array.get(dex2));
        array.set(dex2, temp);
        
        return array;
    }

    /**
     * Bubble sort without improvements
     * @param arr - ArrayList<> to sort
     * @return sorted ArrayList<>
     * @throws sorting.NotSortedException
     * @throws sorting.DifferentTypesException
     */
    public List<T> BubbleSort(List<T> arr) throws NotSortedException, DifferentTypesException {
        List<T> newArr = arr;

        for (int i = 0; i < newArr.size(); i++) {
            for (int j = 0; j < newArr.size(); j++) {

                if (Compare(newArr.get(i), newArr.get(j)) < 0) {
                    T tmp = newArr.get(i);
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
     * @throws sorting.NotSortedException
     * @throws sorting.DifferentTypesException
     */
    public List<T> BubbleSortV2(List<T> arr) throws NotSortedException, DifferentTypesException {
        List<T> newArr = arr;
        boolean swapped = false;

        for (int i = 0; i < newArr.size(); i++) {
            for (int j = 0; j < newArr.size(); j++) {
                if (Compare(newArr.get(i), newArr.get(j)) < 0) {
                    T tmp = newArr.get(i);
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
     * Bubble sort improved by swap flag with steps reduction
     * @param arr ArrayList<> to be sorted
     * @return sorted ArrayList<>
     * @throws sorting.NotSortedException
     * @throws sorting.DifferentTypesException
     */
    public List<T> BubbleSortV3(List<T> arr) throws NotSortedException, DifferentTypesException {

        for (int i = 0; i < arr.size(); i++) {

            for (int j = 0; j < arr.size() - i; j++) {
                if (Compare(arr.get(i), arr.get(j)) < 0) {
                    T tmp = arr.get(i);
                    arr.set(i, arr.get(j));
                    arr.set(j, tmp);
                }
            }
        }

        CheckSorting(arr);
        return arr;
    }

    /**
     * Selection Sort
     * @param arr ArrayList<> to be sorted
     * @return sorted ArrayList<>
     * @throws NotSortedException
     * @throws sorting.DifferentTypesException
     */
    public List<T> SelectionSort(List<T> arr) throws NotSortedException, DifferentTypesException {
        List<T> newArr = arr;

        int k; // index of minimal element
        T x; // value of minimal element

        for(int i = 0; i < newArr.size() - 1; i++) {
            k = i;
            x = newArr.get(i);

            for (int j = i + 1; j < newArr.size(); j++) {
                if (Compare(newArr.get(j), x) < 0) {
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
     * @throws sorting.DifferentTypesException
     */
    public List<T> InsertionSort(List<T> arr) throws NotSortedException, DifferentTypesException {
        List<T> newArr = arr;
        T x;
        int j;

        for (int i = 1; i < newArr.size(); i++) {
            x = newArr.get(i);
            j = i - 1;

            while((j >= 0) && (Compare(x, newArr.get(j)) < 0)) {
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
     * @throws sorting.DifferentTypesException
     */
    public List<T> ShellSort(List<T> arr) throws NotSortedException, DifferentTypesException {

        List<T> newArr = arr;
        int increment = newArr.size() / 2;

        while (increment > 0) {
            for (int i = increment; i < newArr.size(); i++) {
                int j = i;
                T temp = newArr.get(i);

                while ((j >= increment) && Compare(temp, newArr.get(j-increment)) < 0) {
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
     * @throws sorting.DifferentTypesException
     */
    public List<T> ShellSortV2(List<T> arr) throws NotSortedException, DifferentTypesException {
        List<T> newArr = arr;

        int increment = 1;
        double tmp = newArr.size() / 9.0;

        while (increment < tmp) {
            increment = 3 * increment + 1;
        }

        while (increment > 0) {
            for (int i = increment; i < newArr.size(); i++) {
                T temp = newArr.get(i);
                int j = i;

                while ((j >= increment) && Compare(temp, newArr.get(j-increment)) < 0) {
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
     * @return sorted ArrayList<>
     * @throws NotSortedException
     * @throws sorting.DifferentTypesException
     */
    public List<T> QuickSort(List<T> arr, int type) throws NotSortedException, DifferentTypesException {



        if (arr.size() <= 1) {
            return arr;
        }
        
        if (DEBUG) {
            System.out.println();
            if (type == 0) System.out.println("Less");
            if (type == 1) System.out.println("Greater");
            System.out.println(arr + " | " + arr.size());
        }

        T pivot = arr.get(0);

        List<T> less = new ArrayList<>();
        List<T> greater = new ArrayList<>();

        for (int i = 1; i < arr.size(); i++) {
            if (Compare(arr.get(i), pivot) <= 0) {

                less.add(arr.get(i));

            } else if (Compare(arr.get(i), pivot) > 0) {
                greater.add(arr.get(i));
            }
        }

        if (DEBUG) {
            System.out.println("Less array size:" + less.size());
            System.out.println("Greater array size:" + greater.size());
        }

        List<T> newArr = Concatenate(QuickSort(less, 0), pivot, QuickSort(greater, 1));

        CheckSorting(newArr);
        return newArr;
    }

    /**
     * Quick sort recurrent algorithm V2 | Improved by median of 3
     * @param arr ArrayList<> to be sorted
     * @return sorted ArrayList<>
     * @throws NotSortedException
     * @throws sorting.DifferentTypesException
     */
    public List<T> QuickSortV2(List<T> arr, int type) throws NotSortedException, DifferentTypesException {

        if (arr.size() <= 1) {
            return arr;
        }

        if (DEBUG) {
            System.out.println();
            if (type == 0) System.out.println("Less");
            if (type == 1) System.out.println("Greater");
            System.out.println(arr + " | " + arr.size());
        }

        int pivot = medianOf3(arr, 0, arr.size() - 1);
        
        if (DEBUG) {
            System.out.println(arr);        
            System.out.println(arr.get(pivot));
            System.out.println("Index of pivot element: " + arr.indexOf(pivot));
        }
        
        arr = swap(arr, pivot, 0);
        
        if (DEBUG) {
            System.out.println(arr);    
        }

        List<T> less = new ArrayList<>();
        List<T> greater = new ArrayList<>();

        for (int i = 1; i < arr.size(); i++) {
            if (Compare(arr.get(i), arr.get(pivot)) <= 0) {
                less.add(arr.get(i));
            } else {
                greater.add(arr.get(i));
            }
        }
        
        if (DEBUG) {
            System.out.println("Less array size:" + less.size());
            System.out.println("Greater array size:" + greater.size());
        }

        List<T> newArr = Concatenate(QuickSortV2(less, 0), arr.get(pivot), QuickSortV2(greater, 1));

        CheckSorting(newArr);
        return newArr;
    }

    /**
     * Quick sort recurrent algorithm V3
     * @param arr ArrayList<> to be sorted
     * @return sorted ArrayList<>
     * @throws NotSortedException
     * @throws sorting.DifferentTypesException
     */
//    public List<T> QuickSortV3(List<T> arr, int type) throws NotSortedException, DifferentTypesException {
//
//        if (arr.size() <= 1) {
//            return arr;
//        }
//        
//        if (DEBUG) {
//            System.out.println();
//            if (type == 0) System.out.println("Less");
//            if (type == 1) System.out.println("Greater");
//            System.out.println(arr + " | " + arr.size());
//        }
//
//        int middle = (int)Math.max(
//            Math.min(
//                0,
//                Math.floor((double)arr.size()/2)
//            ),
//            Math.min(
//                Math.max(
//                    0,
//                    Math.floor((double)arr.size()/2)),
//                Math.floor((double)arr.size()
//                )
//            )
//        );
//
//        T pivot = arr.get(middle);
//
//        List<T> less = new ArrayList<>();
//        List<T> greater = new ArrayList<>();
//
//        for (int i = 0; i < arr.size(); i++) {
//            if (Compare(arr.get(i), pivot) <= 1){
//                less.add(arr.get(i));
//            } else {
//                greater.add(arr.get(i));
//            }
//        }
//
//        List<T> newArr = Concatenate(QuickSortV3(less, 0), pivot, QuickSortV3(greater, 1));
//
//        CheckSorting(newArr);
//        return newArr;
//    }
    
//    /**
//     * Quick sort expanded by Insertion sort
//     * @param arr ArrayList<> to be sorted
//     * @return sorted ArrayList<>
//     * @throws NotSortedException
//     * @throws sorting.DifferentTypesException
//     */
//    public List<T> Quicksertion(List<T> arr) throws NotSortedException, DifferentTypesException {
//
//        if (arr.size() <= 1) {
//            return arr;
//        }
//
//        if (arr.size() <= 20) {
//            return InsertionSort(arr);
//        }
//
//        int middle = (int)Math.max(
//            Math.min(
//                0,
//                Math.ceil((double)arr.size()/2)
//            ),
//            Math.min(
//                Math.max(
//                    0,
//                    Math.ceil((double)arr.size()/2)),
//                Math.ceil((double)arr.size()
//                )
//            )
//        );
//
//        T pivot = arr.get(middle);
//
//        List<T> less = new ArrayList<>();
//        List<T> greater = new ArrayList<>();
//
//        for (int i = 0; i < arr.size(); i++) {
//            if (Compare(arr.get(i), pivot) <= 0) {
//                if(i == middle){
//                    continue;
//                } less.add(arr.get(i));
//            } else {
//                greater.add(arr.get(i));
//            }
//        }
//
////        List<T> newArr = Concatenate(QuickSort(less), pivot, QuickSort(greater));
//
////        CheckSorting(newArr);
////        return newArr;
//    }
}
