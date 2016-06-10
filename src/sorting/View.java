package sorting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.time.StopWatch;

/**
 * Class responsible for interacting with the program
 * @author krystian
 */
public class View {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Utils utils = new Utils();
        Sorting sorting = Sorting.getInstance();
        StopWatch watch = new StopWatch();

        try {
//            List<Integer> mutableArrayOfNumbers = utils.GenerateArrayOfRandoms(4096000, 1, 1000000);
            List<String> mutableArrayOfStrings = utils.GenerateArrayOfStrings(1024000);
            System.out.println(mutableArrayOfStrings.size());

            /* Sorting of numbers */
//            watch.start();
//            sorting.BubbleSort(new ArrayList<>(mutableArrayOfNumbers));
//            watch.stop();
//            System.out.println("Bubble sort of numbers took " + watch.getTime() + "ms");
//            watch.reset();
//
//            watch.start();
//            sorting.BubbleSortV2(new ArrayList<>(mutableArrayOfNumbers));
//            watch.stop();
//            System.out.println("Improved bubble sort of numbers took " + watch.getTime() + "ms");
//            watch.reset();
//
//            watch.start();
//            sorting.SelectionSort(new ArrayList<>(mutableArrayOfNumbers));
//            watch.stop();
//            System.out.println("Selection sort of numbers took " + watch.getTime() + "ms");
//            watch.reset();
//
//            watch.start();
//            sorting.InsertionSort(new ArrayList<>(mutableArrayOfNumbers));
//            watch.stop();
//            System.out.println("Insertion sort of numbers took " + watch.getTime() + "ms");
//            watch.reset();

//            watch.start();
//            sorting.ShellSort(new ArrayList<>(mutableArrayOfNumbers));
//            watch.stop();
//            System.out.println("Shell sort with h=arr.size()/2 of numbers took " + watch.getTime() + "ms");
//            watch.reset();
//
//            watch.start();
//            sorting.ShellSortV2(new ArrayList<>(mutableArrayOfNumbers));
//            watch.stop();
//            System.out.println("Shell sort with h=1 of numbers took " + watch.getTime() + "ms");
//            watch.reset();
//
//            watch.start();
//            ArrayList<Integer> arr = (ArrayList<Integer>) sorting.QuickSort(new ArrayList<>(mutableArrayOfNumbers), 0);
//            if (Sorting.DEBUG) {
//                System.out.println("Array size after Quicksort: " + arr.size());
//            }
//            watch.stop();
//            System.out.println("Quick sort of numbers took " + watch.getTime() + "ms");
//            watch.reset();
//
//            watch.start();
//            arr = (ArrayList<Integer>) sorting.QuickSortV2(new ArrayList<>(mutableArrayOfNumbers), 0);
//            if (Sorting.DEBUG) {
//                System.out.println("Array size after Quicksort V2: " + arr.size());    
//            }
//            watch.stop();
//            System.out.println("Quick sort V2 of numbers took " + watch.getTime() + "ms");
//            watch.reset();

//            watch.start();
//            arr = (ArrayList<Integer>) sorting.QuickSortV3(new ArrayList<>(mutableArrayOfNumbers), 0);
//            if (Sorting.DEBUG) {
//                System.out.println("Array size after Quicksort V3: " + arr.size());    
//            }
//            sorting.QuickSortV3(new ArrayList<>(mutableArrayOfNumbers), 0);
//            watch.stop();
//            System.out.println("Quick sort V3 of numbers took " + watch.getTime() + "ms");
//            watch.reset();

//            watch.start();
//            sorting.Quicksertion(new ArrayList<>(mutableArrayOfNumbers));
//            watch.stop();
//            System.out.println("Quicksertion of numbers took " + watch.getTime() + "ms");
//            watch.reset();
//
            /* Sorting of strings */
//            watch.start();
//            sorting.BubbleSort(new ArrayList<>(mutableArrayOfStrings));
//            watch.stop();
//            System.out.println("Bubble sort of strings took " + watch.getTime() + "ms");
//            watch.reset();
//
//            watch.start();
//            sorting.BubbleSortV2(new ArrayList<>(mutableArrayOfStrings));
//            watch.stop();
//            System.out.println("Improved bubble sort of strings took " + watch.getTime() + "ms");
//            watch.reset();
//
//            watch.start();
//            sorting.SelectionSort(new ArrayList<>(mutableArrayOfStrings));
//            watch.stop();
//            System.out.println("Selection sort of strings took " + watch.getTime() + "ms");
//            watch.reset();
//
//            watch.start();
//            sorting.InsertionSort(new ArrayList<>(mutableArrayOfStrings));
//            watch.stop();
//            System.out.println("Insertion sort of strings took " + watch.getTime() + "ms");
//            watch.reset();

            watch.start();
            sorting.ShellSort(new ArrayList<>(mutableArrayOfStrings));
            watch.stop();
            System.out.println("Shell sort with h=arr.size()/2 of strings took " + watch.getTime() + "ms");
            watch.reset();

            watch.start();
            sorting.ShellSortV2(new ArrayList<>(mutableArrayOfStrings));
            watch.stop();
            System.out.println("Shell sort with h=1 of strings took " + watch.getTime() + "ms");
            watch.reset();

            watch.start();
            sorting.QuickSort(new ArrayList<>(mutableArrayOfStrings), 0);
            watch.stop();
            System.out.println("Quick sort of strings took " + watch.getTime() + "ms");
            watch.reset();

            watch.start();
            sorting.QuickSortV2(new ArrayList<>(mutableArrayOfStrings), 0);
            watch.stop();
            System.out.println("Quick sort V2 of strings took " + watch.getTime() + "ms");
            watch.reset();

//            watch.start();
//            sorting.QuickSortV3(new ArrayList<>(mutableArrayOfStrings), 0);
//            watch.stop();
//            System.out.println("Quick sort V3 of strings took " + watch.getTime() + "ms");
//            watch.reset();
//
//            watch.start();
//            sorting.Quicksertion(new ArrayList<>(mutableArrayOfStrings));
//            watch.stop();
//            System.out.println("Quicksertion of strings took " + watch.getTime() + "ms");
//            watch.reset();

        } catch (NotSortedException | DifferentTypesException | IOException e) {
            System.out.println(e);
        }
    }
}
