package sorting;

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

        List<Integer> mutableArrayOfNumbers = utils.GenerateArrayOfRandoms(10000, 1, 1000000);

        // Sorting of numbers
        try {

            /* Bubble Sorting */
            watch.start();
            sorting.BubbleSort(new ArrayList<>(mutableArrayOfNumbers));
            watch.stop();
            System.out.println("Bubble sort of the array took " + watch.getTime() + "ms");
            watch.reset();

            watch.start();
            sorting.BubbleSortV2(new ArrayList<>(mutableArrayOfNumbers));
            watch.stop();
            System.out.println("Improved bubble sort of the array took " + watch.getTime() + "ms");
            watch.reset();

            watch.start();
            sorting.BubbleSortV3(new ArrayList<>(mutableArrayOfNumbers));
            watch.stop();
            System.out.println("Improved bubble sort of the array took " + watch.getTime() + "ms");
            watch.reset();

            watch.start();
            sorting.SelectionSort(new ArrayList<>(mutableArrayOfNumbers));
            watch.stop();
            System.out.println("Selection sort of the array took " + watch.getTime() + "ms");
            watch.reset();

            watch.start();
            sorting.InsertionSort(new ArrayList<>(mutableArrayOfNumbers));
            watch.stop();
            System.out.println("Insertion sort of the array took " + watch.getTime() + "ms");
            watch.reset();

            watch.start();
            sorting.ShellSort(new ArrayList<>(mutableArrayOfNumbers));
            watch.stop();
            System.out.println("Shell sort with h=arr.size()/2 of the array took " + watch.getTime() + "ms");
            watch.reset();

            watch.start();
            sorting.ShellSortV2(new ArrayList<>(mutableArrayOfNumbers));
            watch.stop();
            System.out.println("Shell sort with h=1 of the array took " + watch.getTime() + "ms");
            watch.reset();

            watch.start();
            sorting.QuickSort(new ArrayList<>(mutableArrayOfNumbers));
            watch.stop();
            System.out.println("Quick sort of the array took " + watch.getTime() + "ms");
            watch.reset();

            watch.start();
            sorting.QuickSortV2(new ArrayList<>(mutableArrayOfNumbers));
            watch.stop();
            System.out.println("Quick sort V2 of the array took " + watch.getTime() + "ms");
            watch.reset();

            watch.start();
            sorting.QuickSortV3(new ArrayList<>(mutableArrayOfNumbers));
            watch.stop();
            System.out.println("Quick sort V3 of the array took " + watch.getTime() + "ms");
            watch.reset();

            watch.start();
            sorting.Quicksertion(new ArrayList<>(mutableArrayOfNumbers));
            watch.stop();
            System.out.println("Quicksertion of the array took " + watch.getTime() + "ms");
            watch.reset();

        } catch (NotSortedException e) {
            System.out.println(e);
        }
    }
}
